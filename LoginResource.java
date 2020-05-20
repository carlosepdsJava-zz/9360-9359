import org.eclipse.microprofile.rest.client.inject.RestClient;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Path("/api/login")
public class LoginResource {

    @Inject
    @RestClient
    LoginService loginService;

    @POST
    @Path("/v2/login")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)

    public LoginResponse login(AccessLogin accessLogin) {

            return loginService.login(accessLogin);

    }
}
