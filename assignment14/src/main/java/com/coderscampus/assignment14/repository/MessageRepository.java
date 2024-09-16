package com.coderscampus.assignment14.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.coderscampus.assignment14.domain.Message;

@Repository
public class MessageRepository {

	private Map<Long, List<Message>> messagesByChannel = new HashMap<>();
	
	public void addMessage(Long channelId, Message message) {
		messagesByChannel
			.computeIfAbsent(channelId, k -> new ArrayList<>())
			.add(message);
	}
	
	public List<Message> getMessagesByChannel(Long ChannelId) {
		return messagesByChannel.getOrDefault(ChannelId, new ArrayList<>());
	}
	
	public void removeMessagesByChannel(Long channelId) {
		messagesByChannel.remove(channelId);
	}
	
}
