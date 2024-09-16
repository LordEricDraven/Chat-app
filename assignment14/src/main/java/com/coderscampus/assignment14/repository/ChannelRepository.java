package com.coderscampus.assignment14.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.coderscampus.assignment14.domain.Channel;

@Repository
public class ChannelRepository {

	private Map<Long, Channel> channels = new HashMap<>();
	
	public void addChannel(Channel channel) {
		channels.put(channel.getChannelId(), channel);
	}
	
	public Channel getChannelById(Long channelId) {
		return channels.get(channelId);
	}
	
	public List<Channel> getAllChannels(){
		return channels.values().stream().collect(Collectors.toList());
	}
	
	public void removeChannel(Long channelId) {
		channels.remove(channelId);
	}
	
	public boolean channelExists(Long channelId) {
		return channels.containsKey(channelId);
	}
	
}
