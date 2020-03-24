package com.mbhatia.learning.configurations;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.amqp.dsl.Amqp;
import org.springframework.integration.annotation.Poller;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.config.EnableIntegration;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.dsl.Transformers;

@Configuration
@EnableIntegration
public class PostsOutboundConfig {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Bean
    @ServiceActivator(inputChannel = "postsChannel", poller = @Poller(fixedDelay = "1000"))
    public IntegrationFlow toOutboundQueueFlow(){
        return IntegrationFlows.from("postsChannel")
                .transform(Transformers.toJson())
                .handle(Amqp.outboundAdapter(rabbitTemplate))
                .get();
    }


}
