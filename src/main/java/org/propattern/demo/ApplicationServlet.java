package org.propattern.demo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static org.propattern.demo.ApplicationRequest.METHOD;

public class ApplicationServlet extends ExceptionHandlingServlet {
    private METHOD method;
    private ApplicationHandler handler;

    public ApplicationServlet(METHOD method, ApplicationHandler handler) {
        this.method = method;
        this.handler = handler;
    }

    @Override
    public void safeService(HttpServletRequest req, HttpServletResponse res) throws IOException {
        if (invalidRequestMethod(req.getMethod()))
            throw new UnsupportedOperationException();

        sendDown(this.handler.handle(new ApplicationRequest(req), new ApplicationResponse(res)), new ApplicationResponse(res));
    }

    private boolean invalidRequestMethod(String requestMethod) {
        return ! requestMethod.equalsIgnoreCase(this.method.name());
    }
}