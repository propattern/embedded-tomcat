package org.propattern.demo;

import java.io.IOException;

public interface ApplicationHandler {
    void handle(ApplicationRequest request, ApplicationResponse response) throws IOException;
}
