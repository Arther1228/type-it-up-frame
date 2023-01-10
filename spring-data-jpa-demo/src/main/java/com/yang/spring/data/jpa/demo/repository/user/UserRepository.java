package com.yang.spring.data.jpa.demo.repository.user;

import com.yang.spring.data.jpa.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
