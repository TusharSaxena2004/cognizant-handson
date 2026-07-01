import static org.mockito.Mockito.*;
import org.junit.jupiter.api.Test;

public class MyServiceTest {

    @Test
    public void testVerifyInteraction() {
        // 1. Create a mock object.
        ExternalApi mockApi = mock(ExternalApi.class);
        MyService service = new MyService(mockApi);
        
        // 2. Call the method.
        service.fetchData();
        
        // 3. Verify the interaction.
        verify(mockApi).getData();
    }
}