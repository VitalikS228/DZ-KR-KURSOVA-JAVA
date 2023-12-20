
import com.sewaggg.models.Hotel;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HotelTest {

    private Hotel hotel;

    @Before
    public void setUp() {
        hotel = new Hotel("HotelA", "AddressA", 100.0, 20);
    }

    @Test
    public void testGetName() {
        assertEquals("HotelA", hotel.getName());
    }

    @Test
    public void testGetAddress() {
        assertEquals("AddressA", hotel.getAddress());
    }

    @Test
    public void testGetPrice() {
        assertEquals(100.0, hotel.getPrice(), 0.0);
    }

    @Test
    public void testGetAvailableRooms() {
        assertEquals(20, hotel.getAvailableRooms());
    }

    @Test
    public void testBookRoom() {
        hotel.bookRoom();
        assertEquals(19, hotel.getAvailableRooms());
    }

    @Test
    public void testCancelRoom() {
        hotel.cancelRoom();
        assertEquals(21, hotel.getAvailableRooms());
    }
}
