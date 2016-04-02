package com.atoumi.jaxrs.cxf.rest.provider;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Provider
@Produces(MediaType.APPLICATION_JSON)
public class GeneralExceptionMapper implements ExceptionMapper<Exception> {
    /**
     * Map an exception to a {@link javax.ws.rs.core.Response}.
     *
     * @param exception the exception to map to a response.
     * @return a response mapped from the supplied exception.
     */
    @Override
    public Response toResponse(final Exception exception) {
        Map<String, Object> info = new HashMap<>();
        info.put("msg", exception.getMessage());
        info.put("date", new Date());

        return Response
                .status(Response.Status.INTERNAL_SERVER_ERROR)
                .entity(info)
                .type(MediaType.APPLICATION_JSON)
                .build();
    }
}

