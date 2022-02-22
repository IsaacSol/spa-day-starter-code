package org.launchcode.spaday.models;

import javax.validation.constraints.*;

public class User {

    @NotBlank(message = "Username must be provided!")
    @Size(min = 5, max = 15)
    private String username;

    @Email
    private String email;

    @NotBlank(message = "Password must be provided!")
    @Size(min = 6)
    private String password;

    @NotNull(message = "Must verify password!")
    @NotBlank(message = "Must verify password!!!!")
    private String verifyPassword;

    public User() {

    }

    public User(String username, String email, String password, String verifyPassword) {
        this();
        this.username = username;
        this.email = email;
        this.password = password;
        this.verifyPassword = verifyPassword;
    }

    public String getVerifyPassword() {
        return verifyPassword;
    }

    public void setVerifyPassword(String verifyPassword) {
        this.verifyPassword = verifyPassword;
    }

    public String getUsername() {
        return username;
    }

    public boolean checkPassword(){
        return password.equals(verifyPassword);
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
