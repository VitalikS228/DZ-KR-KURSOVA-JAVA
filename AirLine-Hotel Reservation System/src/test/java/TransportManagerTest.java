import com.sewaggg.models.Transport;
import com.sewaggg.utils.TransportManager;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TransportManagerTest {

    private TransportManager transportManager;

    @Before
    public void setUp() {
        transportManager = new TransportManager();
    }

    @Test
    public void testAddTransport() {
        Transport transport = new Transport("RouteA", "TypeA", 50.0, 10);
        transportManager.addTransport("RouteA", transport);

        Map<String, Transport> expectedTransport = new HashMap<>();
        expectedTransport.put("RouteA", transport);

        assertEquals(expectedTransport, transportManager.getAvailableTransport());
    }

    @Test
    public void testGetAvailableTransport() {
        Map<String, Transport> availableTransport = transportManager.getAvailableTransport();
        assertTrue(availableTransport.isEmpty());

        Transport transportA = new Transport("RouteA", "TypeA", 50.0, 10);
        transportManager.addTransport("RouteA", transportA);

        availableTransport = transportManager.getAvailableTransport();
        assertTrue(availableTransport.containsKey("RouteA"));
        assertEquals(transportA, availableTransport.get("RouteA"));
    }

}
