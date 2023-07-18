package com.yang.mybatis.demo.entity.blog;

import lombok.Data;

import java.util.List;

/**
 * @author yangliangchuang 2023/7/18 15:03
 */
@Data
public class Post {

    Integer id;
    String subject;
    Author author;
    List<Comment> comments;
    List<Tag> tags;
}
