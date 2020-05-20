package br.com.carlosepdsJava.login.okta;

import javax.json.bind.annotation.JsonbProperty;

public class LoginResponse {

    private String tokenType;
    private int expiresIn;
    private String accessToken;
    private String refreshToken;

    @JsonbProperty("token_type")
    public String getTokenType() {
        return tokenType;
    }

    @JsonbProperty("token_type")
    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }

    @JsonbProperty("expires_in")
    public int getExpiresIn() {
        return expiresIn;
    }

    @JsonbProperty("expires_in")
    public void setExpiresIn(int expiresIn) {
        this.expiresIn = expiresIn;
    }

    @JsonbProperty("access_token")
    public String getAccessToken() {
        return accessToken;
    }

    @JsonbProperty("access_token")
    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    @JsonbProperty("refresh_token")
    public String getRefreshToken() {
        return refreshToken;
    }

    @JsonbProperty("refresh_token")
    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }
}



