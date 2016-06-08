package org.propattern.demo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ApplicationServlet extends ExceptionHandlingServlet {
    private ApplicationHandler handler;

    public ApplicationServlet(ApplicationHandler handler) {
        this.handler = handler;
    }

    @Override
    public void safeService(HttpServletRequest req, HttpServletResponse res) throws IOException {
        this.handler.handle(new ApplicationRequest(req), new ApplicationResponse(res));
    }
}
