package com.webcodein.admin.config.webservice.ServerInterceptors;


import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;
import javax.ws.rs.ext.ReaderInterceptor;
import javax.ws.rs.ext.ReaderInterceptorContext;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Provider
public class AdminReaderInterceptor implements ReaderInterceptor {

    @Override
    public Object aroundReadFrom(ReaderInterceptorContext context)
            throws IOException, WebApplicationException {
        System.out.println("Check ReaderInterceptorContext ====================> 03 :");
        InputStream is = context.getInputStream();
        String body = new BufferedReader(new InputStreamReader(is)).lines()
                .collect(Collectors.joining("\n"));
        context.setInputStream(new ByteArrayInputStream(
                (body).getBytes()));
        try {
            // Check if the body is going to deserialize or not to LazyFilterModel object
            // If not redirect to WebApplicationException with Bad Request response
            Jsonb jsonb = JsonbBuilder.create();
            return context.proceed();
        } catch (Exception exception) {
            Logger.getLogger(this.getClass().getSimpleName()).log(Level.SEVERE, () -> "Log Cause Message ===> : "+exception.getMessage());
            throw new WebApplicationException(Response.status(400).build());
        }
    }
}