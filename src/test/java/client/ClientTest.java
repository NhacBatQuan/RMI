//package client;
//
//import org.junit.jupiter.api.Test;
//import server.service.RMIService;
//
////import java.rmi.registry.LocateRegistry;
////import java.rmi.registry.Registry;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.Mockito.when;
//
//public class ClientTest {
//
//    @Test
//    public void testClient() throws Exception {
//
////        String[] args = null;
////        Client.main(args);
////        Registry registry = LocateRegistry.getRegistry("localhost",1099);
//        RMIService service = org.mockito.Mockito.mock(RMIService.class);
//        when(service.plus2Number()).thenReturn(15d);
//        when(service.minus2Number()).thenReturn(-1d);
//        when(service.multiple2Number()).thenReturn(56d);
//        when(service.divide2Number()).thenReturn(7/8d);
//        when(service.plusArray()).thenReturn(18d);
//        assertNotNull(service.plus2Number());
//    }
//}