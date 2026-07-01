import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;

public class ShoppingCartTest {

    private ShoppingCart cart;

    // SETUP: Runs automatically before every single @Test method.
    // Use this to initialize shared objects (Test Fixtures).
    @Before
    public void setUp() {
        cart = new ShoppingCart();
    }

    // TEARDOWN: Runs automatically after every single @Test method.
    // Use this to clean up resources, close connections, or reset states.
    @After
    public void tearDown() {
        cart.clear();
        cart = null; 
    }

    @Test
    public void testAddItem() {
        // 1. ARRANGE: Prepare the specific variables and data for this test.
        String expectedItem = "Laptop";
        
        // 2. ACT: Call the specific method you are testing.
        cart.addItem(expectedItem);
        
        // 3. ASSERT: Verify the outcome matches your expectations.
        assertEquals(1, cart.getItemCount());
    }

    @Test
    public void testMultipleItems() {
        // 1. ARRANGE
        String item1 = "Mouse";
        String item2 = "Keyboard";
        
        // 2. ACT
        cart.addItem(item1);
        cart.addItem(item2);
        
        // 3. ASSERT
        assertEquals(2, cart.getItemCount());
    }
}