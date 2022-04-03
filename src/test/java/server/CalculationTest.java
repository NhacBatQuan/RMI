package server;

import org.junit.jupiter.api.Test;
import server.service.RMIServiceImpl;

import java.io.IOException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculationTest {

    public static List<double[]> dataLines = new ArrayList<>();
    public static Calculation cal;
    public static String[] array = new String[15];
    public static String[] f;
    public static double[] numbers;
    static {
        try {
            cal = new Calculation();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public CalculationTest() throws RemoteException {
        super();
    }

    @Test
    void plus2Number() {
        assertEquals(15,cal.plus2Number());
    }
    @Test
    public void Run() throws IOException {
        cal.Run();
    }
//    @Test
//    void Read() throws IOException {
//        cal.ReadJson();
//        System.out.println(array[1]);
//    }
}
