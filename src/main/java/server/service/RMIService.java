package server.service;

import java.io.IOException;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RMIService extends Remote {

    public double plus2Number() throws RemoteException;
    public double minus2Number() throws RemoteException;
    public double multiple2Number() throws RemoteException;
    public double divide2Number() throws Exception;
    public String server_ping() throws RemoteException, Exception;
    public String getStatus() throws Exception;
    public double plusArray() throws IOException, InterruptedException;
    public String CreateCalculation(String pathfinder) throws IOException;
    public String sendPath(String text) throws RemoteException;
    public String time(long end) throws IOException, InterruptedException;

}
