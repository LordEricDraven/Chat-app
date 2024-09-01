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
import com.coderscampus.assignment14.service.ChannelService;

@Controller
@RequestMapping("/channels")
public class ChannelController {

	private final ChannelService channelService;
	
	@Autowired
	public ChannelController(ChannelService channelService) {
		this.channelService = channelService;
	}
	
	@PostMapping("/create")
	public String createChannel(@RequestParam String name, Model model) {
		Channel channel = channelService.createChannel(name);
		model.addAttribute("channel", channel);
		return "redirect:/channels";
	}
	
	@GetMapping("/{ChannelId}")
	@ResponseBody
	public Channel getChannelById(@PathVariable Long channelId) {
		return channelService.getChannelById(channelId);
	}
	
	@GetMapping
	@ResponseBody
	public List<Channel> getAllChannels(){
		return channelService.getAllChannels();
	}
	
}
