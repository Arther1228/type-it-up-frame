package com.yang.mybatis.demo.entity.blog;

import lombok.Data;

/**
 * @author yangliangchuang 2023/7/18 15:47
 */
@Data
public class Author {

    Integer id;
    String username;
    String password;
    String email;
    String bio;
    String favouriteSection;


}
