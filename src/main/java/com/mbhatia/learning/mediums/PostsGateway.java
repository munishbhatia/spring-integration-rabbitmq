package com.mbhatia.learning.mediums;

import com.mbhatia.learning.models.Post;
import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;

@MessagingGateway(name = "postsGateway")
public interface PostsGateway {
    @Gateway(requestChannel = "postsChannel")
    void createPost(Post post);
}
