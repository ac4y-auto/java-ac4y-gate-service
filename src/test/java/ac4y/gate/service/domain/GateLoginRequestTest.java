package ac4y.gate.service.domain;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Unit tests for GateLoginRequest domain class.
 * Tests request object creation and field validation.
 */
public class GateLoginRequestTest {

    @Test
    public void testConstructorWithValidParameters() {
        String username = "testuser";
        String password = "testpass";

        GateLoginRequest request = new GateLoginRequest(username, password);

        assertNotNull("Request object should be created", request);
        assertEquals("Username should match constructor parameter", username, request.getUser());
        assertEquals("Password should match constructor parameter", password, request.getPassword());
    }

    @Test
    public void testConstructorWithNullUsername() {
        GateLoginRequest request = new GateLoginRequest(null, "password");

        assertNotNull("Request object should be created", request);
        assertNull("Username should be null", request.getUser());
        assertEquals("Password should be set", "password", request.getPassword());
    }

    @Test
    public void testConstructorWithNullPassword() {
        GateLoginRequest request = new GateLoginRequest("username", null);

        assertNotNull("Request object should be created", request);
        assertEquals("Username should be set", "username", request.getUser());
        assertNull("Password should be null", request.getPassword());
    }

    @Test
    public void testConstructorWithEmptyStrings() {
        GateLoginRequest request = new GateLoginRequest("", "");

        assertNotNull("Request object should be created", request);
        assertEquals("Username should be empty", "", request.getUser());
        assertEquals("Password should be empty", "", request.getPassword());
    }

    @Test
    public void testSettersAfterConstruction() {
        GateLoginRequest request = new GateLoginRequest("initial", "initial");

        request.setUser("updated");
        request.setPassword("updated");

        assertEquals("Username should be updated", "updated", request.getUser());
        assertEquals("Password should be updated", "updated", request.getPassword());
    }

    @Test
    public void testSpecialCharacters() {
        String specialUsername = "user@example.com";
        String specialPassword = "P@ssw0rd!#$%";

        GateLoginRequest request = new GateLoginRequest(specialUsername, specialPassword);

        assertEquals("Special characters in username should be preserved", specialUsername, request.getUser());
        assertEquals("Special characters in password should be preserved", specialPassword, request.getPassword());
    }

    @Test
    public void testLongCredentials() {
        // Java 8 compatible string building
        StringBuilder sb1 = new StringBuilder(100);
        StringBuilder sb2 = new StringBuilder(100);
        for (int i = 0; i < 100; i++) {
            sb1.append('a');
            sb2.append('b');
        }
        String longUsername = sb1.toString();
        String longPassword = sb2.toString();

        GateLoginRequest request = new GateLoginRequest(longUsername, longPassword);

        assertEquals("Long username should be preserved", longUsername, request.getUser());
        assertEquals("Long password should be preserved", longPassword, request.getPassword());
    }
}
