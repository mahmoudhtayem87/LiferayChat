package com.liferay.custom.chat.filter;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.security.auth.PrincipalException;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.service.UserService;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component(
        immediate = true,
        property = {
                "servlet-context-name=",
                "servlet-filter-name=Liferay WebSocket Filter",
                "url-pattern=/o/lrchat/*"
        },
        service = Filter.class
)
public class WSFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) {
        System.out.println("init filter");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
    	 HttpServletResponse response = (HttpServletResponse) servletResponse;
         HttpServletRequest request = (HttpServletRequest) servletRequest;
    	try {
            String userId = request.getSession().getAttribute(WebKeys.USER_ID).toString();
            String currentURLUserID =((String)request.getAttribute(WebKeys.CURRENT_URL)).replaceAll("[^0-9]", "");
            if (!userId.equals(currentURLUserID) || userId == null) {
            	System.out.println("cancelled");
                PortalUtil.sendError(403, new PrincipalException("Access to chat denied."), request, response);
            }
            filterChain.doFilter(servletRequest, servletResponse);

        } catch (Exception e) {
        	System.out.println("cancelled");
            PortalUtil.sendError(403, new PrincipalException("Access to chat denied."), request, response);
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

    @Override
    public void destroy() {
    }

    @Reference
    private UserLocalService _userLocalService;
    @Reference
    private UserService _userService;

    private static final Log _log = LogFactoryUtil.getLog(WSFilter.class);


}