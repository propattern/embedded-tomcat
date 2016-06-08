package org.propattern.demo;

public class HandlerMapping {
    public final String path;
    public final ApplicationServlet handler;

    public HandlerMapping(String path, ApplicationServlet handler) {
        this.path = path;
        this.handler = handler;
    }
}
