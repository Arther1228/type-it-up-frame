package com.yang.springdatajpademo.repository.user;

import com.yang.springdatajpademo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
