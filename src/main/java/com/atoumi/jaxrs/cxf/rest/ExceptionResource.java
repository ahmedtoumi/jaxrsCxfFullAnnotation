package com.atoumi.jaxrs.cxf.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.atoumi.jaxrs.cxf.util.annotation.RestService;

@RestService
@Path("/exception")
public class ExceptionResource {

    public ExceptionResource() { }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String generateException() throws Exception {
        throw new Exception("generateException from ExceptionResource");
    }
}
