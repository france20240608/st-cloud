package com.st.cloud.agent.mq;

import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

// selectorType 可以不用要  默认值就是TAG
// selectorExpression 过滤多个标签，可以使用逻辑运算符进行组合。RocketMQ 支持以下逻辑运算符：
// ||：表示逻辑或（OR）关系，匹配任意一个条件即可。
// &&：表示逻辑与（AND）关系，需要同时满足所有条件
@Component
@RocketMQMessageListener(topic = "TopicTest", consumerGroup = "cs_group")
public class RocketMQConsumerService implements RocketMQListener<String> {

    @Override
    public void onMessage(String message) {
        // 处理消息的逻辑
        System.out.println("Received message: " + message);
    }
}