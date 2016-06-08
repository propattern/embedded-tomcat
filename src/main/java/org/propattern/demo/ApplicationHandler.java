package org.propattern.demo;

import java.io.IOException;

public interface ApplicationHandler {
    Content handle(ApplicationRequest request, ApplicationResponse response) throws IOException;
}
