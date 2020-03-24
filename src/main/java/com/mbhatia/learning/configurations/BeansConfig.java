package com.mbhatia.learning.configurations;

import com.mbhatia.learning.mediums.PostsGateway;
import com.mbhatia.learning.services.contracts.PostPublisher;
import com.mbhatia.learning.services.implementations.PublishPostImplPrintToConsole;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.channel.QueueChannel;
import org.springframework.messaging.MessageChannel;

@Configuration
public class BeansConfig {
    @Bean
    @Qualifier("postPublisherPrintToConsole")
    public PostPublisher postPublisherPrintToConsole(){
        return new PublishPostImplPrintToConsole();
    }

    @Bean
    public MessageChannel postsChannel(){
       return new QueueChannel();// DirectChannel();
    }
}
