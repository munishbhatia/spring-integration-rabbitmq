package com.mbhatia.learning.controllers;

import com.mbhatia.learning.mediums.PostsGateway;
import com.mbhatia.learning.models.Post;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/forumposts")
@ComponentScan("com.mbhatia.learning.mediums")
public class PostsController {
//    private PostPublisher postPublisher;
    private PostsGateway postsGateway;
//    @Autowired
//    private ApplicationContext applicationContext;

    public PostsController(PostsGateway postsGateway){
        this.postsGateway = postsGateway;
//        System.out.println(applicationContext.getAutowireCapableBeanFactory().toString());
    }

    @PostMapping
    public void createPost(@RequestBody Post post) {
        System.out.println("New post created: " + post.toString());
        postsGateway.createPost(post);
    }
}
