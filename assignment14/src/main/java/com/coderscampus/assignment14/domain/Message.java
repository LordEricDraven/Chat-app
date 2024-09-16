package com.coderscampus.assignment14.domain;

import java.time.LocalDateTime;
import java.util.Objects;

public class Message {

	private String username;
	private String messageContent;
	private LocalDateTime timestamp;
	private Long channelId;
	
	public Message(String username, String messageContent, LocalDateTime timestamp, Long channelId) {
		this.username = username;
		this.messageContent = messageContent;
		this.timestamp = timestamp;
		this.channelId = channelId;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getMessageContent() {
		return messageContent;
	}
	public void setMessageContent(String messageContent) {
		this.messageContent = messageContent;
	}
	public LocalDateTime getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}
	public Long getChannelId() {
		return channelId;
	}
	public void setChannelId(Long channelId) {
		this.channelId = channelId;
	}

	@Override
	public String toString() {
		return "Message [user=" + username + ", messageContent=" + messageContent + ", timestamp=" + timestamp
				+ ", channelId=" + channelId + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(username, timestamp, channelId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;
		Message message = (Message) obj;
		return Objects.equals(channelId, message.channelId) && 
				Objects.equals(timestamp, message.timestamp) && Objects.equals(username, message.username);
	}



}
