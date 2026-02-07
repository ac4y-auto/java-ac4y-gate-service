package ac4y.gate.service.domain;

import ac4y.gate.service.algebra.GateInsertUserRequestAlgebra;

/**
 * Request object for user registration operations.
 *
 * Contains user credentials (username and password) to be sent to the
 * gateway /gate/insertuser endpoint for creating a new user account.
 *
 * Example usage:
 * <pre>
 * GateInsertUserRequest request = new GateInsertUserRequest("newuser", "password123");
 * GateInsertUserResponse response = client.insertUser(request);
 * </pre>
 *
 * @author ac4y
 * @version 1.20190311.2
 */
public class GateInsertUserRequest extends GateInsertUserRequestAlgebra {

    /**
     * Constructs a new insert user request with the specified credentials.
     *
     * @param user the username for the new user account
     * @param password the password for the new user account
     */
    public GateInsertUserRequest(String user, String password){

        setUser(user);
        setPassword(password);

    }

}
