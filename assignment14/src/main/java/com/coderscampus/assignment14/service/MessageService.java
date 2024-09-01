package com.coderscampus.assignment14.service;

import java.time.LocalDateTime;
import java.util.List;

import com.coderscampus.assignment14.domain.Message;
import com.coderscampus.assignment14.domain.User;
import com.coderscampus.assignment14.repository.MessageRepository;

public class MessageService {

	private MessageRepository messageRepo;
	
	public MessageService(MessageRepository messageRepo) {
		this.messageRepo = messageRepo;
	}
	
	public void sendMessage(Long channelId, User user, String content) {
		Message message = new Message(user, content, LocalDateTime.now(), channelId);
		messageRepo.addMessage(channelId, message);
	}
	
	public List<Message> getMessagesByChannel(Long channelId) {
		return messageRepo.getMessagesByChannel(channelId);
	}
	
}
