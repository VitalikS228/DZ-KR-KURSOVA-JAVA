import com.sewaggg.models.User;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class UserTest {

    private User user;

    @Before
    public void setUp() {
        user = new User("testUser", "password123", "client");
    }

    @Test
    public void testGetUsername() {
        assertEquals("testUser", user.getUsername());
    }

    @Test
    public void testGetPassword() {
        assertEquals("password123", user.getPassword());
    }

    @Test
    public void testGetRole() {
        assertEquals("client", user.getRole());
    }

    @Test
    public void testGetPurchasedTickets() {
        assertEquals(0, user.getPurchasedTickets().size());
    }

    @Test
    public void testGetBookedRooms() {
        assertEquals(0, user.getBookedRooms().size());
    }

    @Test
    public void testAddPurchasedTicket() {
        user.addPurchasedTicket("TicketA");
        assertEquals(Arrays.asList("TicketA"), user.getPurchasedTickets());
    }

    @Test
    public void testAddBookedRoom() {
        user.addBookedRoom("RoomA");
        assertEquals(Arrays.asList("RoomA"), user.getBookedRooms());
    }

    @Test
    public void testCancelTicket() {
        user.addPurchasedTicket("TicketB");
        assertTrue(user.cancelTicket("TicketB"));
        assertFalse(user.cancelTicket("NonExistentTicket"));
    }

    @Test
    public void testCancelBookedRoom() {
        user.addBookedRoom("RoomB");
        assertTrue(user.cancelBookedRoom("RoomB"));
        assertFalse(user.cancelBookedRoom("NonExistentRoom"));
    }
}
