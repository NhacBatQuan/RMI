package server;

import client.Client;
import client.model.ClientConfig;
import server.service.RMIService;
import server.service.RMIServiceImpl;

import java.rmi.AlreadyBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Server{
    private static final int PORT = 1099;
    private static Registry registry = null;
    public static double sta = 0;
    public static int Id = 1;
    public static double a = 7d;
    public static double b = 8d;

    public static void startRegistry() throws RemoteException {
        try {
            registry = LocateRegistry.getRegistry(PORT);
            registry.list();
        }
        catch (RemoteException e) {
            registry = LocateRegistry.createRegistry(PORT);
        }

    }
    public static void registerObject(String name, Remote remoteObj)
            throws RemoteException, AlreadyBoundException {
        // Registry object on Register.
        // Assign name.
        // Client find register with name to call object.
        registry.rebind(name, remoteObj);
        System.out.println("Registered: " + name + " -> "
                + remoteObj.getClass().getName() + "[" + remoteObj + "]");
    }

    public static void status() throws Exception{
        if (sta == 1){
            System.out.println("Server online");
        }
        if (sta == 0){
            System.out.println("Server offline");
        }
    }

    public static void main(String[] args) throws Exception {
            startRegistry();
            registerObject(RMIService.class.getSimpleName(), new RMIServiceImpl());
    }
}
