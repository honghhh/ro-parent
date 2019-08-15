package com.project.entity;

public class User {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.username
     *
     * @mbggenerated
     */
    private String username;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.email
     *
     * @mbggenerated
     */
    private String email;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.password
     *
     * @mbggenerated
     */
    private String password;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.activated
     *
     * @mbggenerated
     */
    private Boolean activated;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.activationkey
     *
     * @mbggenerated
     */
    private String activationkey;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.resetpasswordkey
     *
     * @mbggenerated
     */
    private String resetpasswordkey;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.username
     *
     * @return the value of user.username
     *
     * @mbggenerated
     */
    public String getUsername() {
        return username;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.username
     *
     * @param username the value for user.username
     *
     * @mbggenerated
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.email
     *
     * @return the value of user.email
     *
     * @mbggenerated
     */
    public String getEmail() {
        return email;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.email
     *
     * @param email the value for user.email
     *
     * @mbggenerated
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.password
     *
     * @return the value of user.password
     *
     * @mbggenerated
     */
    public String getPassword() {
        return password;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.password
     *
     * @param password the value for user.password
     *
     * @mbggenerated
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.activated
     *
     * @return the value of user.activated
     *
     * @mbggenerated
     */
    public Boolean getActivated() {
        return activated;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.activated
     *
     * @param activated the value for user.activated
     *
     * @mbggenerated
     */
    public void setActivated(Boolean activated) {
        this.activated = activated;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.activationkey
     *
     * @return the value of user.activationkey
     *
     * @mbggenerated
     */
    public String getActivationkey() {
        return activationkey;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.activationkey
     *
     * @param activationkey the value for user.activationkey
     *
     * @mbggenerated
     */
    public void setActivationkey(String activationkey) {
        this.activationkey = activationkey;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.resetpasswordkey
     *
     * @return the value of user.resetpasswordkey
     *
     * @mbggenerated
     */
    public String getResetpasswordkey() {
        return resetpasswordkey;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.resetpasswordkey
     *
     * @param resetpasswordkey the value for user.resetpasswordkey
     *
     * @mbggenerated
     */
    public void setResetpasswordkey(String resetpasswordkey) {
        this.resetpasswordkey = resetpasswordkey;
    }
}