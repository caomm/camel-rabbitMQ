package com.juicelabs.camel.testdemo;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * Created intellij
 * Author: caomm
 * Email: cao_manman@126.com
 * Date: 2016.08.01
 */
public class send {
    public static void main(String args[]){
        ConnectionFactory rabbitConnFactory = new ConnectionFactory();
        rabbitConnFactory.setHost("localhost");
        Connection conn = null;
        try {
            conn = rabbitConnFactory.newConnection();
            final Channel channel = conn.createChannel();
            channel.exchangeDeclare("tasks", "direct", true);
            channel.queueDeclare("task_queue", true, false, false, null);
            channel.queueBind("task_queue", "tasks", "camel");

        } catch (IOException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }

    }
}
