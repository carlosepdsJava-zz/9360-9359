import org.eclipse.microprofile.config.ConfigProvider;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.ws.rs.FormParam;
import javax.ws.rs.HeaderParam;

public class AccessLogin {

    @FormParam("username")
    @Email
    @NotBlank
    public String userName;

    @NotBlank
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{8,16}$")
    @FormParam("password")
    public String password;

    @FormParam("grant_type")
    public String grant_type = ConfigProvider.getConfig().getValue("okta.grant-type", String.class);

    @FormParam("redirect_uri")
    public String redirect_uri = ConfigProvider.getConfig().getValue("okta.redirect-uri", String.class);

    @FormParam("scope")
    public String scope = ConfigProvider.getConfig().getValue("okta.scope", String.class);

    @HeaderParam("Authorization")
    public String authorization = ConfigProvider.getConfig().getValue("okta.app-authorization", String.class);
}