package edu.eci.userapi.controller.auth;

import java.util.Date;

/**
 * TokenDto is used to return the token and expiration date when the authentication is successful
 */
public class TokenDto {

    String token;
    Date expirationDate;

    public TokenDto(String token, Date expirationDate) {
        this.token = token;
        this.expirationDate = expirationDate;
    }

    public String getToken() {
        return token;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }
}
