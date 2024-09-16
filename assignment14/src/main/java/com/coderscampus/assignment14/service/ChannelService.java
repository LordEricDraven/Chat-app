package com.coderscampus.assignment14.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.coderscampus.assignment14.domain.Channel;
import com.coderscampus.assignment14.repository.ChannelRepository;

@Service
public class ChannelService {

	private ChannelRepository channelRepo;
	
	public ChannelService(ChannelRepository channelRepo) {
		this.channelRepo = channelRepo;
	}
	
	public Channel createChannel(String name) {
		Long channelId = generateUniqueId();
		Channel channel = new Channel(name, channelId);
		channelRepo.addChannel(channel);
		return channel;
	}
	
	public Channel getChannelById(Long channelId) {
		return channelRepo.getChannelById(channelId);
	}

	public List<Channel> getAllChannels(){
		return channelRepo.getAllChannels();
	}
	
	private Long generateUniqueId() {
		// TODO Auto-generated method stub
		return System.currentTimeMillis();
	}
	
}
