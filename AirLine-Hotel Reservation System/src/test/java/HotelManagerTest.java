import com.sewaggg.models.Hotel;
import com.sewaggg.utils.HotelManager;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class HotelManagerTest {

    private HotelManager hotelManager;

    @Before
    public void setUp() {
        hotelManager = new HotelManager();
    }

    @Test
    public void testAddHotel() {
        Hotel hotel = new Hotel("HotelA", "AddressA", 100.0, 5);
        hotelManager.addHotel("HotelA", hotel);

        Map<String, Hotel> expectedHotels = new HashMap<>();
        expectedHotels.put("HotelA", hotel);

        assertEquals(expectedHotels, hotelManager.getAvailableHotels());
    }

    @Test
    public void testGetAvailableHotels() {
        Map<String, Hotel> availableHotels = hotelManager.getAvailableHotels();
        assertTrue(availableHotels.isEmpty());

        Hotel hotelA = new Hotel("HotelA", "AddressA", 100.0, 5);
        hotelManager.addHotel("HotelA", hotelA);

        availableHotels = hotelManager.getAvailableHotels();
        assertTrue(availableHotels.containsKey("HotelA"));
        assertEquals(hotelA, availableHotels.get("HotelA"));
    }

}
