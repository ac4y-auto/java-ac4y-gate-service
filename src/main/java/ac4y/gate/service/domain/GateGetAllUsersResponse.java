package ac4y.gate.service.domain;

import ac4y.gate.service.algebra.GateGetAllUsersResponseAlgebra;

/**
 * Response object for retrieving all users from the gateway service.
 *
 * Contains the result of a get all users request made to the
 * gateway /gate/user endpoint. Includes a list of Ac4yUser objects
 * representing all registered users in the system.
 *
 * @author ac4y
 * @version 1.20190311.2
 */
public class GateGetAllUsersResponse extends GateGetAllUsersResponseAlgebra {
}
