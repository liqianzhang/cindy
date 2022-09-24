package com.jiayu;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.concurrent.TimeoutException;

public class Consumer {
    public static void main(String[] args) throws IOException, TimeoutException, InterruptedException {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection connection = connectionFactory.newConnection();
        Channel channel = connection.createChannel();
        String queueName = "test01";
        channel.queueDeclare(queueName, true, false, false, null);
        DefaultConsumer defaultConsumer = new DefaultConsumer(channel) {
            @Override //处理接受到的消息
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println("接收到message：" + new String(body, "UTF-8"));
            }
        };
        channel.basicConsume(queueName, true, defaultConsumer);
    }
}
