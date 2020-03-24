package com.mbhatia.learning.configurations;

import com.mbhatia.learning.models.Post;
import com.mbhatia.learning.services.contracts.PostPublisher;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.amqp.dsl.Amqp;
import org.springframework.integration.annotation.InboundChannelAdapter;
import org.springframework.integration.annotation.Poller;
import org.springframework.integration.config.EnableIntegration;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.dsl.Transformers;

@Configuration
@EnableIntegration
public class PostsInboundConfig {
//    private RabbitTemplate rabbitTemplate;
    private ConnectionFactory connectionFactory;
    private PostPublisher postPublisher;

    public PostsInboundConfig(
                              ConnectionFactory connectionFactory,
                              @Qualifier("postPublisherPrintToConsole") PostPublisher postPublisher) {
//        this.rabbitTemplate = rabbitTemplate;
        this.connectionFactory = connectionFactory;
        this.postPublisher = postPublisher;
    }

    @Bean
    @InboundChannelAdapter(value = "fromPostsRabbit", poller = @Poller(fixedDelay = "1000"))
    public IntegrationFlow inboundFlow(){
        String[] qns = new String[1];
        qns[0] = "POSTS";
        return IntegrationFlows.from(Amqp.inboundAdapter(connectionFactory, qns))
                .transform(Transformers.fromJson(Post.class))
                .handle(postPublisher, "publishPost")
                .get();
    }
}
