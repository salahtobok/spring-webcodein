package com.webcodein.admin.config.webservice.ServerInterceptors;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.ext.Provider;
import javax.ws.rs.ext.WriterInterceptor;
import javax.ws.rs.ext.WriterInterceptorContext;
import java.io.IOException;

@Provider
public class AdminWriterInterceptor implements WriterInterceptor {


    @Override
    public void aroundWriteTo(WriterInterceptorContext context) throws IOException, WebApplicationException {
            System.out.println("Check WriterInterceptor ====================> 06 : ");

        context.proceed();
    }
}