package com.mbhatia.learning.services.implementations;

import com.mbhatia.learning.models.Post;
import com.mbhatia.learning.services.contracts.PostPublisher;
import org.springframework.stereotype.Service;

@Service
public class PublishPostImplPrintToConsole implements PostPublisher {
    @Override
    public void publishPost(Post post) {
        System.out.println("Post published: " + post.toString());
    }
}
