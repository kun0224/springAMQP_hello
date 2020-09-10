package com.lianxi.amqp;


import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class Listener {

    /**
     * 消费者
     *
     * @param message
     */
    @RabbitListener(bindings = {
            @QueueBinding(
                    value = @Queue(value = "spring.test.queue", durable = "true"),
                    exchange = @Exchange(
                            value = "spring.test.exchange",
                            ignoreDeclarationExceptions = "true",
                            type = ExchangeTypes.TOPIC
                    ),
                    key = {"#.#"}
            )
    })
    public void listen(String message) {
        System.out.println("接受到消息：" + message);
    }

}
