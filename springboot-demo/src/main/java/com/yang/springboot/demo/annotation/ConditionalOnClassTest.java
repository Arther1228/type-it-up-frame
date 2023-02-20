package com.yang.springboot.demo.annotation;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.kafka.core.KafkaTemplate;

/**
 * @author yangliangchuang 2022/8/16 11:05
 */

@ConditionalOnClass(KafkaTemplate.class)
public class ConditionalOnClassTest {


}
