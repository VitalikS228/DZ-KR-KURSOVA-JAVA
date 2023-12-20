import com.sewaggg.models.Transport;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TransportTest {

    private Transport transport;

    @Before
    public void setUp() {
        transport = new Transport("Route1", "Bus", 50.0, 30);
    }

    @Test
    public void testGetRoute() {
        assertEquals("Route1", transport.getRoute());
    }

    @Test
    public void testGetType() {
        assertEquals("Bus", transport.getType());
    }

    @Test
    public void testGetPrice() {
        assertEquals(50.0, transport.getPrice(), 0.0);
    }

    @Test
    public void testGetAvailableSeats() {
        assertEquals(30, transport.getAvailableSeats());
    }

    @Test
    public void testBookSeat() {
        transport.bookSeat();
        assertEquals(29, transport.getAvailableSeats());
    }

    @Test
    public void testCancelSeat() {
        transport.cancelSeat();
        assertEquals(31, transport.getAvailableSeats());
    }
}
