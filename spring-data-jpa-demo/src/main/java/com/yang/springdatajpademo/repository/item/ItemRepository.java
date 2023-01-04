package com.yang.springdatajpademo.repository.item;

import com.yang.springdatajpademo.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Integer> {
}
