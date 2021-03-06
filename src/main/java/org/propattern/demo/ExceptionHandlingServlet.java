package org.propattern.demo;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public abstract class ExceptionHandlingServlet extends GenericServlet {
    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        try {
            safeService((HttpServletRequest) req, (HttpServletResponse) res);
        } catch (UnsupportedOperationException uoe) {}
    }

    public abstract void safeService(HttpServletRequest req, HttpServletResponse res) throws IOException;

    protected void sendDown(Content content, ApplicationResponse response) throws IOException {
        content.sendContent(response);
    }
}
