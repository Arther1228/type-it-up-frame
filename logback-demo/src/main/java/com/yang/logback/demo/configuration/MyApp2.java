package com.yang.logback.demo.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.core.util.StatusPrinter;

public class MyApp2 {

    public static final Logger LOGGER = LoggerFactory.getLogger(MyApp2.class);

    public static void main(String[] args) {

        LoggerContext lc = (LoggerContext)LoggerFactory.getILoggerFactory();
        StatusPrinter.print(lc);

        LOGGER.info("Entering application.");

        Foo foo = new Foo();
        foo.doIt();
        LOGGER.info("Exiting application.");
    }
}