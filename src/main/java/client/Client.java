package client;

import client.model.ClientConfig;

import server.service.RMIService;

import java.io.File;
import java.rmi.RemoteException;
import java.rmi.registry.Registry;

public class Client {

    private static Registry registry;

    static ClientConfig getClientConfig(String host, int port){
        ClientConfig clientConfig = new ClientConfig(host, port);
        return clientConfig;
    }

    static RMIService getService(ClientConfig clientConfig) throws Exception
    {
        RMIService service = clientConfig.serviceLookup();
        return service;
    }
    static void getUpload(String [] args) throws Exception {
        String upload ="upload";

    }

    private static Client getService() {
        return null;
    }

//    public static void main(String[] args) throws Exception {
//
//        ClientConfig clientConfig = getClientConfig(HOST, PORT);
//        RMIService service = getService(clientConfig);
//
//        System.out.println("======== Lets Do Some Calculation on Remote Server ========");
////        System.out.println("a =" + a);
////        System.out.println("b =" + b);
//        // Plus a and b
//        double plus = service.plus2Number();
//        System.out.println("a + b =" + plus);
//
//        // Minus a and b
//        double minus = service.minus2Number();
//        System.out.println("a - b =" + minus);
//
//        // Multiple a and b
//        double multiple = service.multiple2Number();
//        System.out.println("a * b =" + multiple);
//
//        // Divide a and b
//        double divide = service.divide2Number();
//        System.out.println("a / b =" + divide);
//
//        double array = service.plusArray();
//        System.out.println("plus array: "+ array);
//    }

}
