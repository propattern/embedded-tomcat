package org.propattern.demo;

import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;

import javax.servlet.ServletException;
import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;

public class WebServer {
    private final Tomcat tomcat;
    private Context context;

    private WebServer(int port) throws ServletException {
        tomcat = new Tomcat();
        tomcat.setPort(port);
        tomcat.setBaseDir(".");
        tomcat.addWebapp("/", new File("src/main/webapp").getAbsolutePath());
        this.context = tomcat.addContext("/api", new File(".").getAbsolutePath());
    }

    public static WebServer aWebServer(int port) throws ServletException {
        return new WebServer(port);
    }

    public static WebServer aWebServer() throws ServletException {
        return aWebServer(0);
    }

    public WebServer start() throws LifecycleException {
        this.tomcat.start();
        return this;
    }

    public URI uriOf(String path) throws URISyntaxException {
        return new URI("http", null, "localhost", port(), path, null, null);
    }

    private int port() {
        return this.tomcat.getService().findConnectors()[0].getLocalPort();
    }

    public WebServer withServlet(HandlerMapping mapping) {
        String name = mapping.handler.toString();

        Tomcat.addServlet(this.context, name, mapping.handler);
        this.context.addServletMapping(mapping.path, name);

        return this;
    }

    public WebServer await() {
        this.tomcat.getServer().await();
        return this;
    }
}
