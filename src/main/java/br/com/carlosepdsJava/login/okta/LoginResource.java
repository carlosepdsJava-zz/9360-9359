package br.com.carlosepdsJava.login.okta;

import org.eclipse.microprofile.metrics.MetricUnits;
import org.eclipse.microprofile.metrics.annotation.Metered;
import org.eclipse.microprofile.metrics.annotation.Timed;
import org.eclipse.microprofile.opentracing.Traced;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.jboss.logging.Logger;
import javax.inject.Inject;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validator;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.HashSet;
import java.util.Set;


@Path("/api/login")
@Traced
public class LoginResource {

    private static final Logger LOG = Logger.getLogger(LoginResource.class);

    @Inject
    Validator validator;

    @Inject
    @RestClient
    LoginService loginService;

    @POST
    @Path("/v2/login")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)

    public LoginResponse login(AccessLogin accessLogin) {

        Set<ConstraintViolation<AccessLogin>> violations = validator.validate(accessLogin);
        if (!violations.isEmpty()) {
            LOG.error("User and password not valid!");
            throw new ConstraintViolationException(new HashSet<>(violations));
        }

            LOG.info("Access Solicited: " + accessLogin.userName);
            return loginService.login(accessLogin);

        }
    }