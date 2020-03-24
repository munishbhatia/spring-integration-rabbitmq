package com.mbhatia.learning.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Post {
    private String postUrl;
    private String postTitle;
}
