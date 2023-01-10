package com.yang.spring.data.jpa.demo.repository.item;

import com.yang.spring.data.jpa.demo.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Integer> {
}
