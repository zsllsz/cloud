package com.zhusl.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;

@EnableBinding(Sink.class)
public class ConsumerController {
	
	@Value("${server.port}")
	private String serverPort;
	
	@StreamListener(Sink.INPUT)
	public void input(Message<String> message) {
		System.out.println("======== 端口：" + serverPort + "，消息内容：" + message.getPayload());
	}

}
