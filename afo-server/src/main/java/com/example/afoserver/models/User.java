package com.example.afoserver.models;

/**
 * A user object contains information about the AFO user's
 * username, password and usertype.
 */
public class User {
    private String username; // username set by user
    private String password; // password set by user
    private String usertype; // otaku or weeb

    /**
     * Get the usertype of this object.
     * @return usertype a String.
     */
    public String getUsertype() {
        return usertype;
    }

    /**
     * Set the usertype of this object
     * @param usertype a String.
     */
    public void setUsertype(String usertype) {
        this.usertype = usertype;
    }

    /**
     * Get the username of this object
     * @return username a String.
     */
    public String getUsername() {
        return username;
    }

    /**
     * Set the username of this object
     * @param username a String.
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Get the username of this object
     * @return password a String.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Set the password of this object
     * @param password a String.
     */
    public void setPassword(String password) {
        this.password = password;
    }
}
