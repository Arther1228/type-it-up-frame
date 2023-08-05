package com.yang.logback.demo.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ch.qos.logback.access.joran.JoranConfigurator;
import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.core.joran.spi.JoranException;
import ch.qos.logback.core.util.StatusPrinter;

public class MyApp3 {

    private static final Logger LOGGER = LoggerFactory.getLogger(MyApp3.class);

    public static void main(String[] args) {

        LoggerContext context = (LoggerContext)LoggerFactory.getILoggerFactory();
        JoranConfigurator joranConfigurator = new JoranConfigurator();
        joranConfigurator.setContext(context);
        context.reset();
        try {
            joranConfigurator.doConfigure(args[0]);
        } catch (JoranException e) {
            e.printStackTrace();
        }

        StatusPrinter.printInCaseOfErrorsOrWarnings(context);

        LOGGER.info("Entering application");

        Foo foo = new Foo();
        foo.doIt();
        LOGGER.info("Exiting application");
    }
}