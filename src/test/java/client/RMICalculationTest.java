package client;

import static client.Client.getService;
//import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Assertions;
import client.model.ClientConfig;
//import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import server.AppManager;
import client.Client;
import server.service.RMIService;
import server.service.RMIServiceImpl;


import java.rmi.NotBoundException;
import java.rmi.RemoteException;

//import jdk.jfr.Timestamp;

/**
 * Unit test for simple App.
 */
public class RMICalculationTest
{
    /**
     * In here, tests are made to check the calculation feature.
     * As in test case description docs, many actions can happen during test, these cases are tested below :-)
     */
//    @BeforeEach
//    void setUp() {
//        calMethod = new calculation();
//    }

    double a = 4.9;
    double b = 5.1;
    String s = "java";
    private static final String HOST = "localhost";
    private static final int PORT = 1099;
    ClientConfig clientConfig = new ClientConfig(HOST, PORT);
//    @Test
    @DisplayName("Calculation result should be true")
    // Server contain data for calculation
    // Run server before test
    public void shouldReceiveCorrectResult() throws Exception {
        clientConfig.serviceLookup().plus2Number();
        RMIService service = getService(clientConfig);
        assertEquals(15d,service.plus2Number());
    }
    @Test
    @DisplayName("Calculation errors should be received from client side")
    // Server contain data for calculation
    // Run server before test
    // To test case divide for 0, change Server.b = 0;
    public void shouldResponseCalculationErrorStatus() throws NotBoundException, Exception
    {
        clientConfig.serviceLookup().plus2Number();
        RMIService service = getService(clientConfig);
        assertEquals(Double.POSITIVE_INFINITY,service.divide2Number());

    }

//    @Test
//    @DisplayName("Calculation validation should be received from client side")
//    public void shouldResponseCalculationErrorStatus()
//    {
//        assertTrue(true);
//    }
//    @Test
//    @DisplayName("Server-client disconnection should be notify")
//    public void shouldResponseDisconnectionTrue()
//    {
//        assertTrue(true);
//    }

}
