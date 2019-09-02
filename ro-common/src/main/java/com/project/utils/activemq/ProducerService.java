package com.project.utils.activemq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

/**
 * @description activemq消息发送者
 * @author: huangh
 * @since 2019-09-02 15:45
 */
@Service
public class ProducerService {

    @Autowired
    private JmsTemplate jmsTemplate;

    /**
     * 发送消息
     * @param destination 队列名
     * @param msg 消息
     * @return
     */
    public void sendMessage(Destination destination, final String msg) {
        System.out.println(Thread.currentThread().getName() + " 向队列" + destination.toString() + "发送消息---------------------->" + msg);
        jmsTemplate.send(destination, new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                return session.createTextMessage(msg);
            }
        });
    }

    /**
     * 用默认队列发送消息
     * @param msg 消息
     * @return
     */
    public void sendMessage(final String msg) {
        Destination destination = jmsTemplate.getDefaultDestination();
        System.out.println(Thread.currentThread().getName() + " 向队列" + destination.toString() + "发送消息---------------------->" + msg);
        jmsTemplate.send(new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                return session.createTextMessage(msg);
            }
        });
    }

}
