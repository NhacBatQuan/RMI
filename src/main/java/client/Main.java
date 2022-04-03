package client;

import client.model.ClientConfig;
import server.RMISpring;
import server.service.RMIService;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;

public class Main {
    //
    private static final String HOST = "localhost";
    private static final int PORT = 1099;
    private static final ClientConfig clientConfig = Client.getClientConfig(HOST, PORT);
    private static RMIService service = null;
    private static String text = ClientConfig.pathfinder;

    static {
        try {
            service = Client.getService(clientConfig);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {
        //TODO: get host, port info from user database
        long start = System.currentTimeMillis();
        //TODO: remove input data, import data from server side
        System.out.println("======== Lets Do Some Calculation on Remote Server ========");

        //TODO: Abstract calculation implementation here, remove old example
        // Plus a and bC
        String status = service.getStatus();
        service.sendPath(text);
//        System.out.println(status);
        service.CreateCalculation(ClientConfig.pathfinder);
        long finish = (System.currentTimeMillis() - start)/1000;
        service.time(finish);


        //        System.out.println("a + b =" + result);
    }
}
