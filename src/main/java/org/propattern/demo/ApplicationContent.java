package org.propattern.demo;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ApplicationContent implements Content {
    private final int statusCode;
    private final Object content;

    public ApplicationContent(int statusCode, Object content) {
        this.statusCode = statusCode;
        this.content = content;
    }

    public static Content OK(Object object) {
        return new ApplicationContent(HttpServletResponse.SC_OK, object);
    }

    @Override
    public void sendContent(ApplicationResponse response) throws IOException {
        response.setStatusCode(this.statusCode);
        response.type("application/json");
        new ObjectMapper().writeValue(response.outputStream(), this.content);
    }
}
