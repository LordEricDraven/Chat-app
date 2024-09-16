package com.coderscampus.assignment14.domain;

import java.util.List;
import java.util.Objects;

public class Channel {

	private String name;
	private Long channelId;
	private List<Message> messages;

	public Channel(String name, Long channelId) {
		this.name = name;
		this.channelId = channelId;
	}
	
	public String getChannelName() {
		return name;
	}
	public void setChannelName(String channelName) {
		this.name = channelName;
	}
	public Long getChannelId() {
		return channelId;
	}
	public void setChannelId(Long channelId) {
		this.channelId = channelId;
	}
	public List<Message> getMessages() {
		return messages;
	}
	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}
	
	@Override
	public String toString() {
		return "Channel [name=" + name + ", channelId=" + channelId + "]";
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(channelId);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;
		Channel channel = (Channel) obj;
		return Objects.equals(channelId, channel.channelId);
	}
}
