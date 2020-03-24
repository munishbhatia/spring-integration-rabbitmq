package com.mbhatia.learning.events;

import com.mbhatia.learning.models.Post;
import lombok.Data;

import java.util.Date;

@Data
public class PostPublishedEvent {
    private Post post;
    private Date publishedAt;
}
