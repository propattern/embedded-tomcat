package org.propattern.demo;

import javax.servlet.http.HttpServletRequest;

public class ApplicationRequest {
    public static enum METHOD {GET}

    private HttpServletRequest request;

    public ApplicationRequest(HttpServletRequest request) {
        this.request = request;
    }
}
