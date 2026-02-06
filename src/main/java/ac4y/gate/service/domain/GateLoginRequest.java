package ac4y.gate.service.domain;

import ac4y.gate.service.algebra.GateLoginRequestAlgebra;

/**
 * Request object for user login operations.
 *
 * Contains user credentials (username and password) to be sent to the
 * gateway /gate/login endpoint for authentication.
 *
 * Example usage:
 * <pre>
 * GateLoginRequest request = new GateLoginRequest("username", "password");
 * GateLoginResponse response = client.login(request);
 * </pre>
 *
 * @author ac4y
 * @version 1.20190311.2
 */
public class GateLoginRequest extends GateLoginRequestAlgebra {

    /**
     * Constructs a new login request with the specified credentials.
     *
     * @param user the username to authenticate
     * @param password the password for authentication
     */
    public GateLoginRequest(String user, String password){

        setUser(user);
        setPassword(password);

    }

}
