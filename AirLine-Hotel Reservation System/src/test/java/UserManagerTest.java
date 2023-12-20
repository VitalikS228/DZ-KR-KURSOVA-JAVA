import com.sewaggg.models.User;
import com.sewaggg.utils.UserManager;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class UserManagerTest {

    private UserManager userManager;

    @Before
    public void setUp() {
        userManager = new UserManager();
    }

    @Test
    public void testAddUser() {
        User user = new User("john_doe", "password123", "client");
        userManager.addUser("john_doe", user);

        Map<String, User> expectedUserMap = new HashMap<>();
        expectedUserMap.put("john_doe", user);

        assertEquals(expectedUserMap, userManager.getUserMap());
    }

    @Test
    public void testGetUserMap() {
        Map<String, User> userMap = userManager.getUserMap();
        assertTrue(userMap.isEmpty());

        User userA = new User("userA", "passA", "client");
        userManager.addUser("userA", userA);

        userMap = userManager.getUserMap();
        assertTrue(userMap.containsKey("userA"));
        assertEquals(userA, userMap.get("userA"));
    }

    @Test
    public void testAuthenticateUser() {
        User user = new User("john_doe", "password123", "client");
        userManager.addUser("john_doe", user);

        // Test successful authentication
        User authenticatedUser = userManager.authenticateUser("john_doe", "password123");
        assertEquals(user, authenticatedUser);

        // Test authentication failure (wrong password)
        authenticatedUser = userManager.authenticateUser("john_doe", "wrong_password");
        assertNull(authenticatedUser);

        // Test authentication failure (wrong username)
        authenticatedUser = userManager.authenticateUser("wrong_username", "password123");
        assertNull(authenticatedUser);
    }
}
