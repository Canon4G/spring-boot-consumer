package com.canon4g.consumer.MQ;

import com.canon4g.provider.model.User;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * create by Canon4G 2019-01-07
 **/
@Component
public class MQReceive {

    @RabbitListener(queues = "queue")   //监听器监听指定的Queue
    public void receive(User user) {
//        System.out.println("Receive: " + str);
        System.out.println("Receive: " + user.toString());
    }

}
