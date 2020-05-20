package br.com.carlosepdsJava.login.exceptions;

import org.jboss.logging.Logger;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Provider
public class BeanValConstrainViolationExceptionMapper implements ExceptionMapper<ConstraintViolationException> {
    private static final Logger LOG = Logger.getLogger(BeanValConstrainViolationExceptionMapper.class);

    @Override
    public Response toResponse(ConstraintViolationException e) {
        Set<ConstraintViolation<?>> cv = e.getConstraintViolations();
        final List<String> errors = cv.stream().map(c -> c.getPropertyPath() + " " + c.getMessage()).collect(Collectors.toList());
        LOG.error(e.getMessage());
        String message = "{\"erro\": \"Check user and password data.\"}";
        return Response.status(Response.Status.BAD_REQUEST)
                .entity(message)
                .type(MediaType.APPLICATION_JSON)
                .build();

    }


}
