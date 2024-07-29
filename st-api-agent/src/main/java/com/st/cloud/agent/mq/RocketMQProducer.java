package com.st.cloud.agent.mq;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;

public class RocketMQProducer {
    public static void main(String[] args) throws Exception {
        // 创建一个生产者实例
        DefaultMQProducer producer = new DefaultMQProducer("ProducerGroupName");
        // 设置NameServer地址
        producer.setNamesrvAddr("192.168.19.131:9876");
        // 启动生产者实例
        producer.start();

        // 创建一条消息
        Message msg = new Message("cs_group",
                "TagA",
                "Hello RocketMQ".getBytes());

        // 发送消息
        SendResult sendResult = producer.send(msg);
        System.out.printf("%s%n", sendResult);

        // 关闭生产者实例
        producer.shutdown();
    }
}

//docker run -d  --restart=always --name rmqnamesrv -p 9876:9876  -v  /docker/rocketmq/data/namesrv/logs:/root/logs  -v /docker/rocketmq/data/namesrv/store:/root/store  -e "MAX_POSSIBLE_HEAP=10000000"  rocketmqinc/rocketmq sh mqnamesrv
//docker run -d --restart=always --name rmqbroker --link rmqnamesrv:namesrv -p 10911:10911 -p 10909:10909  -v /data/broker/logs:/root/logs -v /data/broker/store:/root/store  -v  /data/broker/conf/broker.conf:/opt/rocketmq-4.4.0/conf/broker.conf  -e "NAMESRV_ADDR=namesrv:9876"  -e "MAX_POSSIBLE_HEAP=10000000"  rocketmqinc/rocketmq sh mqbroker -c /opt/rocketmq-4.4.0/conf/broker.conf

// mkdir -p  /docker/rocketmq/data/namesrv/logs  /docker/rocketmq/data/namesrv/store

//docker run -d --restart=always --name rmqnamesrv -p 9876:9876 -v /docker/rocketmq/data/namesrv/logs:/root/logs -v /docker/rocketmq/data/namesrv/store:/root/store -e "MAX_POSSIBLE_HEAP=200000000" rocketmqinc/rocketmq sh mqnamesrv
//
//mkdir -p  /docker/rocketmq/data/broker/logs  /docker/rocketmq/data/broker/store /docker/rocketmq/conf
//
//docker run -d --restart=always --name rmqbroker --link rmqnamesrv:namesrv -p 10911:10911 -p 10909:10909 -v  /docker/rocketmq/data/broker/logs:/root/logs -v /docker/rocketmq/data/broker/store:/root/store -v /docker/rocketmq/conf/broker.conf:/opt/rocketmq/conf/broker.conf -e "NAMESRV_ADDR=namesrv:9876" -e "MAX_POSSIBLE_HEAP=100000000" rocketmqinc/rocketmq sh mqbroker -c /opt/rocketmq/conf/broker.conf
//
//docker run -d --restart=always --name rmqadmin -e "JAVA_OPTS=-Drocketmq.namesrv.addr=192.168.19.131:9876 -Dcom.rocketmq.sendMessageWithVIPChannel=false" -p 9999:8080 pangliang/rocketmq-console-ng
//
//# 所属集群名称，如果节点较多可以配置多个
//brokerClusterName = DefaultCluster
//#broker名称，master和slave使用相同的名称，表明他们的主从关系
//brokerName = broker-a
//#0表示Master，大于0表示不同的slave
//brokerId = 0
//#表示几点做消息删除动作，默认是凌晨4点
//deleteWhen = 04
//#在磁盘上保留消息的时长，单位是小时
//fileReservedTime = 48
//#有三个值：SYNC_MASTER，ASYNC_MASTER，SLAVE；同步和异步表示Master和Slave之间同步数据的机制；
//brokerRole = ASYNC_MASTER
//#刷盘策略，取值为：ASYNC_FLUSH 表示同步刷盘,SYNC_FLUSH 异步刷盘；SYNC_FLUSH消息写入磁盘后才返回成功状态，ASYNC_FLUSH不需要；
//flushDiskType = ASYNC_FLUSH
//# 设置broker节点所在服务器的ip地址
//brokerIP1 = 47.112.153.198
//# 磁盘使用达到95%之后,生产者再写入消息会报错 CODE: 14 DESC: service not available now, maybe disk full
//diskMaxUsedSpaceRatio = 95
