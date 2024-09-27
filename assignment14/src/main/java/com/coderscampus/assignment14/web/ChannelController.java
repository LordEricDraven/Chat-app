package com.coderscampus.assignment14.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.coderscampus.assignment14.domain.Channel;
import com.coderscampus.assignment14.domain.Message;
import com.coderscampus.assignment14.service.ChannelService;
import com.coderscampus.assignment14.service.MessageService;

@Controller
@RequestMapping("/channels")
public class ChannelController {

	private final ChannelService channelService;
	private final MessageService messageService;
	
	@Autowired
	public ChannelController(ChannelService channelService, MessageService messageService) {
		this.channelService = channelService;
		this.messageService = messageService;
	}
	
	@PostMapping("/create")
	public String createChannel(@RequestParam String name, Model model) {
		Channel channel = channelService.createChannel(name);
		model.addAttribute("channel", channel);
		return "redirect:/channels";
	}
	
	@GetMapping("/{channelId}")
	public String showChannelPage(@PathVariable Long channelId, Model model) {
		Channel channel = channelService.getChannelById(channelId);
		model.addAttribute("channel", channel);
		return "channel";
	}

	@GetMapping("/{channelId}/details")
	@ResponseBody
	public Channel getChannelDetails(@PathVariable Long channelId) {
		return channelService.getChannelById(channelId);
	}
	
//	@GetMapping("/{channelId}/messages")
//	@ResponseBody
//	public List<Message> getMessagesByChannel(@PathVariable Long channelId){
//		return messageService.getMessagesByChannel(channelId);
//	}
	
	@PostMapping("/{channelId}/messages")
	@ResponseBody
	public Message postMessageToChannel(@PathVariable Long channelId, @RequestParam String username, @RequestParam String messageContent) {
		return messageService.addMessageToChannel(channelId, username, messageContent);
	}
	
	@GetMapping
	public String getAllChannels(Model model){
		List<Channel> channels = channelService.getAllChannels();
		model.addAttribute("channels", channels);
		return "channels";
	}
	
}
