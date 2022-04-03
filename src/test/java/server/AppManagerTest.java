package server;

import org.junit.jupiter.api.Test;
import server.service.RMIServiceImpl;

import java.rmi.RemoteException;

import static org.junit.jupiter.api.Assertions.*;

class AppManagerTest {
    private RMIServiceImpl service;
    private static long start = 0;
    private static long finish;
    private Calculation calculation;

    public AppManagerTest() throws RemoteException {
        super();
        this.service = new RMIServiceImpl();
    }

    @Test
    void plus2Number() {
        assertEquals(15,service.plus2Number());
    }

    @Test
    void minus2Number() {
        assertEquals(-1,service.minus2Number());
    }

    @Test
    void multiple2Number() {
        assertEquals(56,service.multiple2Number());
    }

    @Test
    void divide2Number() throws Exception {
        assertEquals(0.875,service.divide2Number());
    }
    @Test
    void plusArray() throws Exception{
        assertEquals(18,service.plusArray());
    }
    @Test
    void TimeElapsed() throws Exception{
        AppManager.requestCalculation("path");
        Thread.sleep(1);
    }

    @Test
    void server_ping() {
    }
}