package org.propattern.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class PersonHandler implements ApplicationHandler {
    private Person person;

    private static final Logger LOGGER = LoggerFactory.getLogger(PersonHandler.class);

    public PersonHandler(Person person) {
        this.person = person;
    }

    @Override
    public Content handle(ApplicationRequest request, ApplicationResponse response) throws IOException {
        LOGGER.info("YOYOYO");
        return ApplicationContent.OK(this.person);
    }
}
