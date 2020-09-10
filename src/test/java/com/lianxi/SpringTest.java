package com.lianxi;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MyAppliation.class)
public class SpringTest {

    @Autowired
    AmqpTemplate amqpTemplate;


    /**
     * 生产者
     */
    @Test
    public void test01() {
        String message = "hello Spring_AMQP";
        amqpTemplate.convertAndSend("spring.test.exchange", "a.b", message);
    }

}
