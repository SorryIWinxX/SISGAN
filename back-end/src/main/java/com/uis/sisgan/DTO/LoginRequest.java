package com.uis.sisgan.DTO;

/**
 * LoginRequest is a Data Transfer Object (DTO) that encapsulates the information
 * required for a login request. This class includes the user's email and password.
 */
public class LoginRequest {

    // The email of the user attempting to log in
    private String email;

    // The password of the user attempting to log in
    private String password;

    /**
     * Gets the email of the user.
     *
     * @return the user's email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the email of the user.
     *
     * @param email the email to be set for the user
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets the password of the user.
     *
     * @return the user's password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the password of the user.
     *
     * @param password the password to be set for the user
     */
    public void setPassword(String password) {
        this.password = password;
    }
}