package ac4y.gate.service.domain;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Unit tests for GateInsertUserRequest domain class.
 * Tests request object creation and field validation for user insertion.
 */
public class GateInsertUserRequestTest {

    @Test
    public void testConstructorWithValidParameters() {
        String username = "newuser";
        String password = "newpass123";

        GateInsertUserRequest request = new GateInsertUserRequest(username, password);

        assertNotNull("Request object should be created", request);
        assertEquals("Username should match constructor parameter", username, request.getUser());
        assertEquals("Password should match constructor parameter", password, request.getPassword());
    }

    @Test
    public void testConstructorWithNullUsername() {
        GateInsertUserRequest request = new GateInsertUserRequest(null, "password");

        assertNotNull("Request object should be created", request);
        assertNull("Username should be null", request.getUser());
        assertEquals("Password should be set", "password", request.getPassword());
    }

    @Test
    public void testConstructorWithNullPassword() {
        GateInsertUserRequest request = new GateInsertUserRequest("username", null);

        assertNotNull("Request object should be created", request);
        assertEquals("Username should be set", "username", request.getUser());
        assertNull("Password should be null", request.getPassword());
    }

    @Test
    public void testConstructorWithEmptyStrings() {
        GateInsertUserRequest request = new GateInsertUserRequest("", "");

        assertNotNull("Request object should be created", request);
        assertEquals("Username should be empty", "", request.getUser());
        assertEquals("Password should be empty", "", request.getPassword());
    }

    @Test
    public void testSettersAfterConstruction() {
        GateInsertUserRequest request = new GateInsertUserRequest("initial", "initial");

        request.setUser("modified");
        request.setPassword("modified");

        assertEquals("Username should be modified", "modified", request.getUser());
        assertEquals("Password should be modified", "modified", request.getPassword());
    }

    @Test
    public void testEmailAsUsername() {
        String email = "newuser@example.com";
        String password = "secure123";

        GateInsertUserRequest request = new GateInsertUserRequest(email, password);

        assertEquals("Email as username should be preserved", email, request.getUser());
    }

    @Test
    public void testComplexPassword() {
        String username = "admin";
        String complexPassword = "C0mpl3x!P@ssw0rd#2024$";

        GateInsertUserRequest request = new GateInsertUserRequest(username, complexPassword);

        assertEquals("Complex password should be preserved", complexPassword, request.getPassword());
    }

    @Test
    public void testUnicodeCharacters() {
        String unicodeUsername = "用户名";
        String unicodePassword = "пароль123";

        GateInsertUserRequest request = new GateInsertUserRequest(unicodeUsername, unicodePassword);

        assertEquals("Unicode username should be preserved", unicodeUsername, request.getUser());
        assertEquals("Unicode password should be preserved", unicodePassword, request.getPassword());
    }
}
