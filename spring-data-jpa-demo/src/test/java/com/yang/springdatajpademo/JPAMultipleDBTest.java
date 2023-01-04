package com.yang.springdatajpademo;

import com.yang.springdatajpademo.model.Item;
import com.yang.springdatajpademo.model.User;
import com.yang.springdatajpademo.repository.item.ItemRepository;
import com.yang.springdatajpademo.repository.user.UserRepository;
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