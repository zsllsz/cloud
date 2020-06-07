package com.zhusl.springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zhusl.springcloud.service.IMessageProvider;

@RestController
@RequestMapping("/stream")
public class SendMessageController {
	
	@Autowired
	private IMessageProvider messageProvider;
	
	@GetMapping("/message")
	public String send() {
		messageProvider.send();
		return "success";
	}

}
