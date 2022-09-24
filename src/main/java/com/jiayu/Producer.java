package com.jiayu;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Producer {
	public static void main(String[] args) throws IOException, TimeoutException {
		ConnectionFactory connectionFactory = new ConnectionFactory();
		connectionFactory.setHost("localhost");
		connectionFactory.setPort(5672);
		connectionFactory.setVirtualHost("/");
		Connection connection = connectionFactory.newConnection();
		Channel channel = connection.createChannel();
		String msg = "我爱高倩";
		channel.basicPublish("", "test01",null,msg.getBytes());
//		channel.close();
//		connection.close();
	}

}
