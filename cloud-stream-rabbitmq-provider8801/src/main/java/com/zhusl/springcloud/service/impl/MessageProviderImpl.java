package com.zhusl.springcloud.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;

import com.zhusl.springcloud.service.IMessageProvider;

@EnableBinding(Source.class)
public class MessageProviderImpl implements IMessageProvider{
	
	@Autowired
	private MessageChannel output;

	@Override
	public void send() {
		String msg = "hello world";
		output.send(MessageBuilder.withPayload(msg).build());
		System.out.println("============== 发送成功 ==============");
	}

}
