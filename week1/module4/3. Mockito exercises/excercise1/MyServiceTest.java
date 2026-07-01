import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class MyServiceTest {

    @Test
    public void testExternalApi() {
        // 1. Create the mock object
        ExternalApi mockApi = mock(ExternalApi.class);

        // 2. Stub the method
        when(mockApi.getData()).thenReturn("Mock Data");

        // 3. Test using the mock
        MyService service = new MyService(mockApi);
        String result = service.fetchData();

        // Assert the result
        assertEquals("Mock Data", result);
    }
}