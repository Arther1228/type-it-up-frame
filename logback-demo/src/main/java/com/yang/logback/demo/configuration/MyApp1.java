package com.yang.logback.demo.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyApp1 {

    public static final Logger LOGGER = LoggerFactory.getLogger(MyApp1.class);

    public static void main(String[] args) {
        LOGGER.info("Entering application.");

        Foo foo = new Foo();
        foo.doIt();
        LOGGER.info("Exiting application.");
    }   
}