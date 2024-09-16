package com.coderscampus.assignment14.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coderscampus.assignment14.domain.Message;
import com.coderscampus.assignment14.domain.User;
import com.coderscampus.assignment14.repository.MessageRepository;

@Service
public class MessageService {

	private final MessageRepository messageRepo;
	
	@Autowired
	public MessageService(MessageRepository messageRepo) {
		this.messageRepo = messageRepo;
	}
	
	public Message addMessageToChannel(Long channelId, String username, String messageContent) {
		Message message = new Message(username, messageContent, LocalDateTime.now(), channelId);
		messageRepo.addMessage(channelId, message);
		return message;
	}

	public List<Message> getMessagesByChannel(Long channelId) {
		return messageRepo.getMessagesByChannel(channelId);
	}
	
}
