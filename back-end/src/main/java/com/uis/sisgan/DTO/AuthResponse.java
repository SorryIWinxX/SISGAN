package com.uis.sisgan.DTO;

/**
 * AuthResponse is a Data Transfer Object (DTO) that encapsulates the response information
 * for an authentication request. This class includes the access token, token type, and user role.
 */
public class AuthResponse {

    // The access token for the authenticated user
    private String accesToken;

    // The type of the token, default is "Bearer "
    private String tokenType = "Bearer ";

    // The role of the authenticated user
    private String role;

    /**
     * Gets the role of the authenticated user.
     *
     * @return the role of the user
     */
    public String getRole() {
        return role;
    }

    /**
     * Sets the role of the authenticated user.
     *
     * @param role the role to be set for the user
     */
    public void setRole(String role) {
        this.role = role;
    }

    /**
     * Constructs a new AuthResponse with the specified access token and role.
     *
     * @param accesToken the access token for the authenticated user
     * @param role the role of the authenticated user
     */
    public AuthResponse(String accesToken, String role) {
        this.accesToken = accesToken;
        this.role = role;
    }

    /**
     * Gets the access token for the authenticated user.
     *
     * @return the access token
     */
    public String getAccesToken() {
        return accesToken;
    }

    /**
     * Sets the access token for the authenticated user.
     *
     * @param accesToken the access token to be set
     */
    public void setAccesToken(String accesToken) {
        this.accesToken = accesToken;
    }

    /**
     * Gets the type of the token.
     *
     * @return the token type, default is "Bearer "
     */
    public String getTokenType() {
        return tokenType;
    }

    /**
     * Sets the type of the token.
     *
     * @param tokenType the token type to be set
     */
    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }
}