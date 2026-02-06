package ac4y.gate.service.client;

import ac4y.gate.service.domain.*;
import ac4y.service.adapter.Ac4yRestServiceClient;
import com.google.gson.Gson;

import java.io.IOException;

/**
 * REST client for the Ac4y Gateway authentication service.
 *
 * This client provides methods to interact with the Ac4y Gateway API for
 * user authentication and management operations including login, user
 * registration, and user retrieval.
 *
 * Example usage:
 * <pre>
 * Ac4yGateServiceClient client = new Ac4yGateServiceClient("http://gateway.ac4y.com:8080");
 * GateLoginRequest request = new GateLoginRequest("username", "password");
 * GateLoginResponse response = client.login(request);
 * </pre>
 *
 * All methods return response objects rather than throwing exceptions,
 * providing graceful error handling through response error fields.
 *
 * @author ac4y
 * @version 1.20190311.2
 */
public class Ac4yGateServiceClient {

    /**
     * Constructs a new Ac4yGateServiceClient with the specified gateway host.
     *
     * @param host the gateway host URL (e.g., "http://gateway.ac4y.com:8080")
     */
    public Ac4yGateServiceClient(String host) {
        this.setHost(host);
    }

    /**
     * Gets the configured gateway host URL.
     *
     * @return the gateway host URL
     */
    public String getHost() {
        return host;
    }

    /**
     * Sets the gateway host URL.
     *
     * @param host the gateway host URL to set
     */
    public void setHost(String host) {
        this.host = host;
    }

    /** The gateway host URL */
    protected String host;

    /**
     * Retrieves all users from the gateway service.
     *
     * Makes a GET request to /gate/user endpoint to retrieve the complete list
     * of users from the authentication gateway.
     *
     * @return GateGetAllUsersResponse containing the list of users or error information
     */
    public GateGetAllUsersResponse getAllUsers() {

        try {

            return (GateGetAllUsersResponse) new Gson().fromJson(
                new Ac4yRestServiceClient().request(
                        this.getHost()+"/gate/user"
                        ,"GET"
                        ,null
                )
                , GateGetAllUsersResponse.class
            );

        } catch (
                IOException exception) {
            return (GateGetAllUsersResponse) new GateGetAllUsersResponse().error(new Ac4yRestServiceClient().getStackTraceAsString(exception));
        }

    } // getAllUsers

    /**
     * Authenticates a user with the gateway service.
     *
     * Makes a POST request to /gate/login endpoint with user credentials
     * to authenticate against the Ac4y authentication system.
     *
     * @param request the login request containing username and password
     * @return GateLoginResponse indicating success or failure with error information
     */
    public GateLoginResponse login(GateLoginRequest request) {

        try {

            return (GateLoginResponse) new Gson().fromJson(
                new Ac4yRestServiceClient().request(
                        this.getHost()+"/gate/login"
                        ,"POST"
                        ,new Gson().toJson(request)
                )
                , GateLoginResponse.class
            );

        } catch (
                IOException exception) {
            return (GateLoginResponse) new GateLoginResponse().error(new Ac4yRestServiceClient().getStackTraceAsString(exception));
        }

    } // login

    /**
     * Registers a new user with the gateway service.
     *
     * Makes a POST request to /gate/insertuser endpoint to create a new user
     * in the Ac4y authentication system.
     *
     * @param request the insert user request containing username and password for the new user
     * @return GateInsertUserResponse indicating success or failure with error information
     */
    public GateInsertUserResponse insertUser(GateInsertUserRequest request) {

        try {

            return (GateInsertUserResponse) new Gson().fromJson(
                    new Ac4yRestServiceClient().request(
                            this.getHost()+"/gate/insertuser"
                            ,"POST"
                            ,new Gson().toJson(request)
                    )
                    , GateInsertUserResponse.class
            );

        } catch (
                IOException exception) {
            return (GateInsertUserResponse) new GateInsertUserResponse().error(new Ac4yRestServiceClient().getStackTraceAsString(exception));
        }

    } // insertUser

//    = (Ac4yGateGetAllUsersResponse) new Gson().fromJson(response, Ac4yGateGetAllUsersResponse.class);


//    Ac4yGateGetAllUsersResponse gateGetAllUsersResponse = (Ac4yGateGetAllUsersResponse) new Gson().fromJson(response, Ac4yGateGetAllUsersResponse.class);

}
