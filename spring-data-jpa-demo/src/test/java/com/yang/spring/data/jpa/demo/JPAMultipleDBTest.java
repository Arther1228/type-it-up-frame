package com.yang.spring.data.jpa.demo;

import com.yang.spring.data.jpa.demo.repository.item.ItemRepository;
import com.yang.spring.data.jpa.demo.repository.user.UserRepository;
import com.yang.spring.data.jpa.demo.model.Item;
import com.yang.spring.data.jpa.demo.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class JPAMultipleDBTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ItemRepository itemRepository;

    @Test
    public void whenCreatingUser_thenCreated() {
        User user = new User();
        user.setName("John");
        user.setEmail("john@test.com");
        user.setAge(20);
        user = userRepository.save(user);

        assertNotNull(userRepository.findById(user.getId()));
    }

    @Test
    public void whenCreatingProduct_thenCreated() {
        Item item = new Item();
        item.setName("Book");
        item.setId(2);
        item = itemRepository.save(item);

        assertNotNull(itemRepository.findById(item.getId()));
    }


}