package server;

import java.io.IOException;
import java.rmi.RemoteException;

import static java.lang.Boolean.TRUE;

public class RMISpring {
    public static String calculationStatus;

    public String getStatus(String c) throws IOException {
        c = calculationStatus;
        return c;
    }
}
