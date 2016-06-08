package org.propattern.demo;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ApplicationResponse {
    private HttpServletResponse res;

    public ApplicationResponse(HttpServletResponse res) {
        this.res = res;
    }

    public void OK(Object object) throws IOException {
        res.setContentType("application/json");
        ((HttpServletResponse) res).setStatus(HttpServletResponse.SC_OK);

        new ObjectMapper().writeValue(res.getOutputStream(), object);
    }
}
