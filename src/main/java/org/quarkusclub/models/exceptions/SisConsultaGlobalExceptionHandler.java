package org.quarkusclub.models.exceptions;

import org.jboss.logging.Logger;

import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class SisConsultaGlobalExceptionHandler implements ExceptionMapper<SisConsultaException> {

    @Inject
    Logger log;

    @Override
    public Response toResponse(SisConsultaException e) {
        log.info("Tratamento de erro global: " + e.toString());

        return Response.status(e.getStatus())
                .entity(new ErrorModel(e.getStatus(), e.getMessage()))
                .build();
    }
}