package org.propattern.demo;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;

public class ApplicationResponse {
    private HttpServletResponse response;

    public ApplicationResponse(HttpServletResponse response) {
        this.response = response;
    }

    public void setStatusCode(int statusCode) {
        this.response.setStatus(statusCode);
    }

    public void type(String type) {
        this.response.setContentType(type);
    }

    public OutputStream outputStream() throws IOException {
        return this.response.getOutputStream();
    }
}
