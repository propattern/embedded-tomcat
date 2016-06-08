package org.propattern.demo;

import com.jayway.jsonassert.JsonAssert;
import org.apache.http.client.fluent.Executor;
import org.apache.http.client.fluent.Request;
import org.apache.http.client.fluent.Response;
import org.apache.http.impl.client.HttpClients;
import org.junit.Test;

import java.net.URI;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.propattern.demo.WebServer.aWebServer;

public class PersonHandlerTest {
    @Test
    public void theHandlerReturnsTheCorrectExpectedValues() throws Exception {
        WebServer server = aWebServer()
                .withServlet(new HandlerMapping("/person", new ApplicationServlet(new PersonHandler(new Person("John", "Doe", 25)))))
                .start();

        Executor executor = Executor.newInstance(HttpClients.createDefault());
        URI uri = server.uriOf("/api/person");
        Response response = executor.execute(Request.Get(uri));

        String content = response.returnContent().asString();

        JsonAssert.with(content)
            .assertThat("$.firstName", equalTo("John"))
            .assertThat("$.lastName", equalTo("Doe"))
            .assertThat("$.age", equalTo(25))
        ;
    }
}
