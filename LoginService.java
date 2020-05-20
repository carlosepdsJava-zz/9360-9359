import org.eclipse.microprofile.rest.client.annotation.ClientHeaderParam;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import javax.ws.rs.BeanParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

@Path("/v1")
@RegisterRestClient(configKey = "login-api")

public interface LoginService {

    @POST
    @Path("/token")
    @ClientHeaderParam(name = "Accept", value = MediaType.APPLICATION_JSON)
    @ClientHeaderParam(name = "Content-Type", value = MediaType.APPLICATION_FORM_URLENCODED)

    LoginResponse login(@BeanParam AccessLogin accessLogin);
}

