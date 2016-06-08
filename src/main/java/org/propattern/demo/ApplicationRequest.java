package org.propattern.demo;

import javax.servlet.http.HttpServletRequest;

public class ApplicationRequest {
    private HttpServletRequest req;

    public ApplicationRequest(HttpServletRequest req) {
        this.req = req;
    }
}
