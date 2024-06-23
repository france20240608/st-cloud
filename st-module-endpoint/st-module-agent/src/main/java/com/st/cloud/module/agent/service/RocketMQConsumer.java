package com.st.cloud.module.agent.service;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;

public class RocketMQConsumer {
    public static void main(String[] args) throws Exception {
        // 创建一个消费者实例
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("ConsumerGroupName");
        // 设置NameServer地址
        consumer.setNamesrvAddr("192.168.19.131:9876");
        // 订阅一个或多个Topic，以及Tag来过滤需要消费的消息
        consumer.subscribe("cs_group", "*");

        // 注册回调实现类来处理从broker拉取回来的消息
        consumer.registerMessageListener((MessageListenerConcurrently) (msgs, context) -> {
            System.out.printf("%s Receive New Messages: %s %n", Thread.currentThread().getName(), msgs);
            // 标记该消息已经被成功消费
            return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
        });

        // 启动消费者实例
        consumer.start();

        System.out.printf("Consumer Started.%n");
    }
}