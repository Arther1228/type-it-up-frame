package com.yang.springdatajpademo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @author yangliangchuang 2022/11/17 14:14
 */
@Data
@Entity
@Table(name = "dev_user")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DevUser {
    @Id
    private Integer id;
    private String username;
    private String password;
    private Date addtime;

}
