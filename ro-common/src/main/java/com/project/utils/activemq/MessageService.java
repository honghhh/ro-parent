package com.project.utils.activemq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.jms.Destination;
import javax.jms.TextMessage;

/**
 * 消息工具服务层
 */
public class MessageService {

    private Logger logger = LoggerFactory.getLogger(MessageService.class);

    @Autowired
    private Destination destination;

    // 队列消息生产者
    @Autowired
    private ProducerService producerService;

    // 队列消息消费者
    @Autowired
    private ConsumerService consumerService;

    public void send(String msg) {
        logger.info(Thread.currentThread().getName() + "------------send to jms Start");
        producerService.sendMessage(msg);
        logger.info(Thread.currentThread().getName() + "------------send to jms End");
    }

    public Object receive() {
        logger.info(Thread.currentThread().getName() + "------------receive from jms Start");
        TextMessage tm = consumerService.receive(destination);
        logger.info(Thread.currentThread().getName() + "------------receive from jms End");
        return tm;
    }
}
