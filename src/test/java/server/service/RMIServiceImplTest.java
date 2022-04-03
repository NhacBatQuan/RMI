package server.service;

import org.junit.jupiter.api.Test;
import server.AppManager;
import server.Server;
import server.service.RMIService;
import server.service.RMIServiceImpl;

import java.rmi.RemoteException;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.mockito.Mockito.when;

public class RMIServiceImplTest {
    public static String[] array = new String[5];
    public static String[] f;
    public static double[] numbers;

    RMIService rmiService = new RMIServiceImpl();

    public RMIServiceImplTest() throws RemoteException {
    }

//    @Test
//    public void testRMIService() throws Exception {
//
//        RMIService service = org.mockito.Mockito.mock(RMIServiceImpl.class);
//        when(service.plus2Number()).thenReturn(10d);
//        when(service.minus2Number()).thenReturn(-1d);
//        when(service.multiple2Number()).thenReturn(56d);
//        when(service.divide2Number()).thenReturn(7/8d);
//        when(service.plusArray()).thenReturn(18d);
//    }

    @Test
    public void testRMIServiceImplPlus() throws Exception {
        assertEquals(15d, rmiService.plus2Number());
    }

    @Test
    public void testRMIServiceImplMinus() throws Exception {
        assertEquals(-1d, rmiService.minus2Number());
    }

    @Test
    public void testRMIServiceImplMultiple() throws Exception {
        assertEquals(56d, rmiService.multiple2Number());
    }

    @Test
    public void testRMIServiceImplDivide() throws Exception {
        assertEquals(0.875d, rmiService.divide2Number());
    }
    @Test
    public void testRMIServiceImplArray() throws Exception {
        assertEquals(18, rmiService.plusArray());
    }

}
