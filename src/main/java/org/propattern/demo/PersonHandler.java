package org.propattern.demo;

import java.io.IOException;

public class PersonHandler implements ApplicationHandler {
    private Person person;

    public PersonHandler(Person person) {
        this.person = person;
    }

    @Override
    public void handle(ApplicationRequest request, ApplicationResponse response) throws IOException {
        response.OK(this.person);
    }
}
