package com.liferay.custom.chat;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.liferay.custom.chat.model.*;


import com.liferay.custom.chat.services.service.service.MessageLocalService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.Image;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.UserConstants;
import com.liferay.portal.kernel.service.ImageLocalServiceUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.webserver.WebServerServletTokenUtil;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;


import javax.servlet.http.HttpSession;
import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;

import java.awt.List;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Component(immediate = true, service = Endpoint.class,
        property = {"org.osgi.http.websocket.endpoint.path=/o/lrchat/{username}"}
)
@ServerEndpoint("/o/lrchat/{username}")
public class WebSocketEndpoint extends Endpoint {

    private HttpSession httpSession;
    
    private static Map<String, Session> activeSessions = new HashMap<String, Session>();
    private static Map<String,ActiveUser> activeUsers = new HashMap<String,ActiveUser>();
   
    @Override
    public void onClose(Session session, CloseReason closeReason)
    {
    	String username = session.getPathParameters().get("username");
    	if(activeSessions.containsKey(username))
    		activeSessions.remove(username);

        if(activeUsers.containsKey(username))
            activeUsers.remove(username);
        broadcastNewUser();
    }
    void broadcastNewUser()
    {
        ObjectMapper mapper = new ObjectMapper();
        webSocketMessage msg = new webSocketMessage();
        msg.setMessageText(" --- ");
        msg.setMessageType("activeUsers");
        activeSessions.forEach((userId, session) -> {
            try {
                msg.setToUserId(userId);
                msg.setData(activeUsers);
                session.getBasicRemote().sendText(mapper.writeValueAsString(msg));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
    void activeUsersResponse(String userId)
    {
        ObjectMapper mapper = new ObjectMapper();
        webSocketMessage msg = new webSocketMessage();
        msg.setMessageText(" --- ");
        msg.setMessageType("activeUsers");
        try {
            msg.setToUserId(userId);
            msg.setData(activeUsers);
            activeSessions.get(userId).getBasicRemote().sendText(mapper.writeValueAsString(msg));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void onOpen(final Session session, EndpointConfig endpointConfig) {


        String username = session.getPathParameters().get("username");
        User user = null;
        try {
            user = _userLocalService.getUser(Long.parseLong(username));
            ActiveUser activeUser = new ActiveUser(username,user.getFullName());
            String userAvatar = UserConstants.getPortraitURL("",user.isMale(),user.getPortraitId(),user.getUserUuid());
            activeUser.setAvatar("/image/"+userAvatar);
            activeUsers.put(username,activeUser);
        } catch (PortalException e) {
            e.printStackTrace();
        }

        activeSessions.put(username, session);

        broadcastNewUser();
        
        session.addMessageHandler(new MessageHandler.Whole<String>() {
            @Override
            public void onMessage(String msg) {
                ObjectMapper mapper = new ObjectMapper();
                try {
                    webSocketMessage messageObj = mapper.readValue(msg, webSocketMessage.class);
                    messageObj.setFromUserId(username);
                    switch (messageObj.getMessageType())
                    {
                        case "request_active_users":
                            activeUsersResponse(username);
                            break;
                        case "message":
                            messageObj.setSentDate(System.currentTimeMillis());
                            Session target = activeSessions.getOrDefault(messageObj.getToUserId(), null);
                            if(target != null)
                            {
                                System.out.println("sending out the msg");
                                String msgObjectString = mapper.writeValueAsString( messageObj);
                                target.getBasicRemote().sendText(msgObjectString);
                            }
                            _messageLocalService
                                    .addMessage(messageObj.getFromUserId(),messageObj.getToUserId()
                                            ,messageObj.getMessageText(),"message");
                            break;
                        default:
                            break;
                    }
                } catch (IOException ioe) {
                    System.out.println(ioe.getMessage());
                } catch (Exception ioe) {
                    System.out.println(ioe.getMessage());
                }
            }
        });
    }

    public ServiceContext getContext(long groupId) {
        ServiceContext serviceContext = new ServiceContext();

        serviceContext.setScopeGroupId(groupId);
        return serviceContext;
    }
    @Reference
    private UserLocalService _userLocalService;

    @Reference
    private MessageLocalService _messageLocalService;


}