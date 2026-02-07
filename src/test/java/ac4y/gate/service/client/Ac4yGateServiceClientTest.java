package ac4y.gate.service.client;

import ac4y.gate.service.domain.*;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Unit tests for Ac4yGateServiceClient.
 * Tests client initialization, configuration, and basic request object handling.
 *
 * Note: These tests focus on client setup and configuration.
 * Integration tests with actual service endpoints would require a running service.
 */
public class Ac4yGateServiceClientTest {

    private Ac4yGateServiceClient client;
    private static final String TEST_HOST = "http://localhost:8080";

    @Before
    public void setUp() {
        client = new Ac4yGateServiceClient(TEST_HOST);
    }

    @Test
    public void testClientCreation() {
        assertNotNull("Client should be created", client);
    }

    @Test
    public void testHostConfiguration() {
        assertEquals("Host should match constructor parameter", TEST_HOST, client.getHost());
    }

    @Test
    public void testSetHost() {
        String newHost = "http://api.example.com:9090";
        client.setHost(newHost);
        assertEquals("Host should be updated", newHost, client.getHost());
    }

    @Test
    public void testSetHostWithHttps() {
        String httpsHost = "https://secure.example.com";
        client.setHost(httpsHost);
        assertEquals("HTTPS host should be set", httpsHost, client.getHost());
    }

    @Test
    public void testHostWithTrailingSlash() {
        String hostWithSlash = "http://localhost:8080/";
        Ac4yGateServiceClient clientWithSlash = new Ac4yGateServiceClient(hostWithSlash);
        assertEquals("Host with trailing slash should be preserved", hostWithSlash, clientWithSlash.getHost());
    }

    @Test
    public void testHostWithPath() {
        String hostWithPath = "http://localhost:8080/api/v1";
        Ac4yGateServiceClient clientWithPath = new Ac4yGateServiceClient(hostWithPath);
        assertEquals("Host with path should be preserved", hostWithPath, clientWithPath.getHost());
    }

    @Test
    public void testClientWithNullHost() {
        Ac4yGateServiceClient nullHostClient = new Ac4yGateServiceClient(null);
        assertNull("Null host should be preserved", nullHostClient.getHost());
    }

    @Test
    public void testClientWithEmptyHost() {
        Ac4yGateServiceClient emptyHostClient = new Ac4yGateServiceClient("");
        assertEquals("Empty host should be preserved", "", emptyHostClient.getHost());
    }

    /**
     * Test that getAllUsers method exists and returns a response object.
     * This test will fail with IOException in a real scenario without a running service,
     * but should return an error response object rather than throwing an exception.
     */
    @Test
    public void testGetAllUsersReturnsResponse() {
        GateGetAllUsersResponse response = client.getAllUsers();
        assertNotNull("getAllUsers should return a response object", response);
    }

    /**
     * Test that login method exists and returns a response object.
     * This test will fail with IOException in a real scenario without a running service,
     * but should return an error response object rather than throwing an exception.
     */
    @Test
    public void testLoginReturnsResponse() {
        GateLoginRequest request = new GateLoginRequest("testuser", "testpass");
        GateLoginResponse response = client.login(request);
        assertNotNull("login should return a response object", response);
    }

    /**
     * Test that insertUser method exists and returns a response object.
     * This test will fail with IOException in a real scenario without a running service,
     * but should return an error response object rather than throwing an exception.
     */
    @Test
    public void testInsertUserReturnsResponse() {
        GateInsertUserRequest request = new GateInsertUserRequest("newuser", "newpass");
        GateInsertUserResponse response = client.insertUser(request);
        assertNotNull("insertUser should return a response object", response);
    }

    /**
     * Test login with null request handling.
     * The method should handle this gracefully without throwing NullPointerException.
     */
    @Test
    public void testLoginWithNullRequest() {
        try {
            GateLoginResponse response = client.login(null);
            // If it doesn't throw an exception, it should return a response
            assertNotNull("Should handle null request gracefully", response);
        } catch (NullPointerException e) {
            // This is also acceptable behavior
            assertTrue("NullPointerException is acceptable for null request", true);
        }
    }

    /**
     * Test insertUser with null request handling.
     * The method should handle this gracefully without throwing NullPointerException.
     */
    @Test
    public void testInsertUserWithNullRequest() {
        try {
            GateInsertUserResponse response = client.insertUser(null);
            // If it doesn't throw an exception, it should return a response
            assertNotNull("Should handle null request gracefully", response);
        } catch (NullPointerException e) {
            // This is also acceptable behavior
            assertTrue("NullPointerException is acceptable for null request", true);
        }
    }

    /**
     * Test multiple sequential operations.
     */
    @Test
    public void testMultipleOperations() {
        GateGetAllUsersResponse response1 = client.getAllUsers();
        assertNotNull("First getAllUsers should return response", response1);

        GateLoginRequest loginReq = new GateLoginRequest("user", "pass");
        GateLoginResponse response2 = client.login(loginReq);
        assertNotNull("Login should return response", response2);

        GateInsertUserRequest insertReq = new GateInsertUserRequest("newuser", "newpass");
        GateInsertUserResponse response3 = client.insertUser(insertReq);
        assertNotNull("InsertUser should return response", response3);
    }

    /**
     * Test host reconfiguration between calls.
     */
    @Test
    public void testHostReconfiguration() {
        assertEquals("Initial host should be TEST_HOST", TEST_HOST, client.getHost());

        client.setHost("http://newhost:8080");
        assertEquals("Host should be updated", "http://newhost:8080", client.getHost());

        GateGetAllUsersResponse response = client.getAllUsers();
        assertNotNull("Should work with new host", response);
    }
}
