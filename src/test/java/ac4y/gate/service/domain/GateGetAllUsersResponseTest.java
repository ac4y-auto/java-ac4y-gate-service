package ac4y.gate.service.domain;

import ac4y.gate.domain.Ac4yUser;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;

/**
 * Unit tests for GateGetAllUsersResponse domain class.
 * Tests response object creation and list handling.
 */
public class GateGetAllUsersResponseTest {

    @Test
    public void testResponseCreation() {
        GateGetAllUsersResponse response = new GateGetAllUsersResponse();
        assertNotNull("Response object should be created", response);
    }

    @Test
    public void testSetAndGetUserList() {
        GateGetAllUsersResponse response = new GateGetAllUsersResponse();
        List<Ac4yUser> users = new ArrayList<>();

        Ac4yUser user1 = new Ac4yUser();
        user1.setUser("user1");
        user1.setPassword("pass1");

        Ac4yUser user2 = new Ac4yUser();
        user2.setUser("user2");
        user2.setPassword("pass2");

        users.add(user1);
        users.add(user2);

        response.setList(users);

        assertNotNull("User list should not be null", response.getList());
        assertEquals("User list should contain 2 users", 2, response.getList().size());
        assertEquals("First user should match", "user1", response.getList().get(0).getUser());
        assertEquals("Second user should match", "user2", response.getList().get(1).getUser());
    }

    @Test
    public void testEmptyUserList() {
        GateGetAllUsersResponse response = new GateGetAllUsersResponse();
        List<Ac4yUser> emptyList = new ArrayList<>();

        response.setList(emptyList);

        assertNotNull("Empty list should not be null", response.getList());
        assertEquals("List should be empty", 0, response.getList().size());
        assertTrue("List should be empty", response.getList().isEmpty());
    }

    @Test
    public void testNullUserList() {
        GateGetAllUsersResponse response = new GateGetAllUsersResponse();

        response.setList(null);

        assertNull("List should be null", response.getList());
    }

    @Test
    public void testLargeUserList() {
        GateGetAllUsersResponse response = new GateGetAllUsersResponse();
        List<Ac4yUser> users = new ArrayList<>();

        for (int i = 0; i < 1000; i++) {
            Ac4yUser user = new Ac4yUser();
            user.setUser("user" + i);
            user.setPassword("pass" + i);
            users.add(user);
        }

        response.setList(users);

        assertEquals("Large user list should be preserved", 1000, response.getList().size());
        assertEquals("First user should be correct", "user0", response.getList().get(0).getUser());
        assertEquals("Last user should be correct", "user999", response.getList().get(999).getUser());
    }

    @Test
    public void testModifyListAfterSet() {
        GateGetAllUsersResponse response = new GateGetAllUsersResponse();
        List<Ac4yUser> users = new ArrayList<>();

        Ac4yUser user = new Ac4yUser();
        user.setUser("original");
        users.add(user);

        response.setList(users);

        // Modify the original list
        Ac4yUser newUser = new Ac4yUser();
        newUser.setUser("additional");
        users.add(newUser);

        // Response list should reflect the change (since it's the same reference)
        assertEquals("List modification should be reflected", 2, response.getList().size());
    }
}
