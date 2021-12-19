package com.liferay.custom.chat.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class webSocketMessage {

    @JsonProperty("toUserId")
    private String toUserId;
    @JsonProperty("fromUserId")
    private String fromUserId;
    @JsonProperty("data")
    private Object data;
    @JsonProperty("messageType")
    private String messageType;
    @JsonProperty("messageText")
    private String messageText;
    @JsonProperty("groupId")
    private long groupId;
    @JsonProperty("createDate")
    private long sentDate;

    public long getSentDate() {return sentDate;}
    public void setSentDate(long sentDate) {this.sentDate = sentDate;}
    public String getToUserId() {
        return toUserId;
    }
    public void setToUserId(String toUserId) {
        this.toUserId = toUserId;
    }
    public String getMessageText() {
        return messageText;
    }
    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }
    public long getGroupId() {
        return groupId;
    }
    public void setGroupId(long groupId) {
        this.groupId = groupId;
    }
    public String getFromUserId() {return fromUserId;}
    public void setFromUserId(String fromUserId) {this.fromUserId = fromUserId;}
    public Object getData() {
        return data;
    }
    public void setData(Object data) {
        this.data = data;
    }
    public String getMessageType() {
        return messageType;
    }
    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }


}
