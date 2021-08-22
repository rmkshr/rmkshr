package com.spring.security.apisecurity.utils;


public class Constants {

    /**
     * API SECURITY MODULE CONSTANTS.
     */
    public static final String KEY_SPACE = "key ";
    public static final String SECRET = "secret";
    public static final String ROLES = "roles";
    public static final String ACCESS_TOKEN = "access_token";
    public static final String REFRESH_TOKEN = "refresh_token";
    public static final String ERROR = "error";
    public static final String ERROR_MESSAGE = "error_message";
    public static final String TOKEN_MISSING_EXCEPTION = "Refresh token is missing";
    public static final String USERNAME = "username";
    public static final String PASSWORD = "password";
    public static final String USERNAME_LOGGER = "UserName is {}";
    public static final String PASSWORD_LOGGER = "Password is {}";
    public static final String ERROR_LOGGING_IN_LOGGEER = "Error Logging in : {}";
    public static final String ROLE_SUPER_ADMIN = "ROLE_SUPER_ADMIN";
    public static final String SAVE_USER_LOGGER = "Saving new user {} to database";
    public static final String SAVE_ROLE_LOGGER = "Saving new role {} to database";
    public static final String SAVE_ROLE_TO_USER_LOGGER = "Saving new role {} to user {}";
    public static final String FETCHING_USER_LOGGER = "Fetching user {}";
    public static final String FETCHING_ALL_USER_LOGGER = "Fetching all users";
    public static final String USER_NOT_FOUND_LOGGER = "User not found in the Database";
    public static final String USER_NOT_FOUND_PARAM_LOGGER = "User found in the Database: {}";
}
