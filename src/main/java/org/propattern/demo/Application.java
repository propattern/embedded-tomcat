package org.propattern.demo;

import org.apache.catalina.LifecycleException;

import javax.servlet.ServletException;

import static org.propattern.demo.ApplicationRequest.METHOD;
import static org.propattern.demo.ApplicationRequest.METHOD.GET;

public class Application {

    public static void main(String[] args) throws Exception {
        WebServer server = WebServer.aWebServer(8080)
                .withServlet(new HandlerMapping("/person", servlet(GET, new PersonHandler(new Person("Nap", "Person", 28)))))
                .start();

        server.await();
    }

    private static ApplicationServlet servlet(METHOD method, ApplicationHandler handler) {
        return new ApplicationServlet(method, handler);
    }
}
