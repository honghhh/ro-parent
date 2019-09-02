package com.project.utils.activemq;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * @description api activemq消息监听器
 * @author: huangh
 * @since 2019-09-02 15:44
 */
public class ApiQueueMessageListener implements MessageListener {

    @Override
    public void onMessage(Message message) {
        TextMessage tm = (TextMessage) message;
        try {
            System.out.println("ApiQueueMessageListener监听到了文本消息：\t"
                    + tm.getText());
            //do something ...
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
