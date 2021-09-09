package edu.eci.userapi.controller.auth;

/**
 * LoginDto is used to map the JSON send to authenticate a user: Java.
 */
public class LoginDto {

    String email;
    String password;

    public LoginDto(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }


}
