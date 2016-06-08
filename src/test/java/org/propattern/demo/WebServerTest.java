package org.propattern.demo;

import org.apache.http.client.fluent.Executor;
import org.apache.http.client.fluent.Request;
import org.apache.http.client.fluent.Response;
import org.apache.http.impl.client.HttpClients;
import org.junit.Test;

import static javax.servlet.http.HttpServletResponse.SC_OK;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.propattern.demo.WebServer.aWebServer;

public class WebServerTest {
    @Test
    public void webServerIsReachableOnceStarted() throws Exception {
        WebServer server = aWebServer().start();

        Executor executor = Executor.newInstance(HttpClients.createDefault());
        Response response = executor.execute(Request.Get(server.uriOf("")));

        int statusCode = response.returnResponse().getStatusLine().getStatusCode();

        assertThat(statusCode, equalTo(SC_OK));
    }
}
