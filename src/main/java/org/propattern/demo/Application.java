package org.propattern.demo;

import org.apache.catalina.LifecycleException;

import javax.servlet.ServletException;

public class Application {

    public static void main(String[] args) throws ServletException, LifecycleException {
        WebServer server = WebServer.aWebServer(8080)
                .withServlet(new HandlerMapping("/person", servlet(new PersonHandler(new Person("Nap", "Person", 28)))))
                .start();

        server.await();
    }

    private static ApplicationServlet servlet(ApplicationHandler handler) {
        return new ApplicationServlet(handler);
    }
}
