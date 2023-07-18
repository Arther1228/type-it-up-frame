package com.yang.mybatis.demo.entity.blog;

import lombok.Data;


import java.util.List;

/**
 * @author yangliangchuang 2023/7/18 15:03
 */
@Data
public class Blog {

    Integer id;
    String title;
    Author author;
    List<Post> posts;

    public Blog(Integer id) {
        this.id = id;
    }
}
