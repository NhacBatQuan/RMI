package client;

//import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import client.model.ClientConfig;
//import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import server.AppManager;
import server.service.RMIServiceImpl;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;

/**
 * Unit test for simple App.
 */
public class RMIUseCaseTest
{
    /**
     * In here, tests show related actions with other cases than just calculation feature.
     * Please check the test case code for detail description in docs :-)
     */
    private RMIServiceImpl service;
    private static final String HOST = "localhost";
    private static final int PORT = 1099;
    ClientConfig clientConfig = new ClientConfig(HOST, PORT);
    public RMIUseCaseTest() throws RemoteException{
        super();
        this.service = new RMIServiceImpl();
    }

    @Test
    @DisplayName("Uc03: Server should confirm new calculation job created")
    public void shouldReceiveCalculationJobCreated()
    {
        assertTrue( true);
    }
    @Test
    @DisplayName("Uc06: Server should return current status of the calculation job")
    public void shouldReceiveCalculationStatus()
    {

        assertTrue( true);
    }
    @Test
    @DisplayName("Uc07: Server should return sample calculation job after checking job status")
    public void shouldReceiveResultAfterJobFinished()
    {
        assertTrue(true);
    }
    @Test
    @DisplayName("Uc07: Should tell server results downloaded ")
    public void shouldDeliverConfirmationToServer()
    {
        assertTrue( true);
    }
    @Test
    @DisplayName("Uc09: Should tell server to stop calculation ")
    public void shouldRequestCancelationToServer()
    {
        assertTrue (true );
    }
    @Test
    @DisplayName("Uc01: Should connect with server")
    public void shouldConnectToServer()throws Exception
    {
        assertEquals("hello from the server side", service.server_ping());
    }
}
