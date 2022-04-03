package server.service;

import server.AppManager;
import server.Calculation;
import server.Server;

import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import static server.Calculation.array;

public class RMIServiceImpl extends UnicastRemoteObject implements RMIService {
    public static double status = Server.a;
    public RMIServiceImpl() throws RemoteException {
        try {
           Calculation.array();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public double plusArray() throws IOException {
        double e = 0;
        while (System.currentTimeMillis() < Calculation.end) {
            e = AppManager.plusArray();
        }
        return e;
    }

    public static String setPath(String text){
        String text1 = text;
        return text1;
    }

    public String CreateCalculation(String path) throws IOException {
        //TODO: put task to AppManager
        try {
            AppManager.requestCalculation(path);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        //TODO: return string confirm to client
        return "Calculation Created";
    }

    public String sendPath(String path) {
        String path1 = path;
        return path;
    }

    @Override
    public String time(long end) throws IOException, InterruptedException {
        AppManager.time(end);
        return null;
    }

    public double plus2Number() {
        double c = 0;
        while (System.currentTimeMillis() < Calculation.end){
        try {
            c = AppManager.plus2Number();
        } catch (IOException e) {
            e.printStackTrace();
            }
        }
        return c;
    }

    public double minus2Number() {
        double c = 0;
        while (System.currentTimeMillis() < Calculation.end) {
            try {
                c = AppManager.minus2Number();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } return c;
    }

    public double multiple2Number() {
        double c = 0;
        while (System.currentTimeMillis() < Calculation.end) {
            try {
                c = AppManager.multiple2Number();
            } catch (RemoteException e) {
                e.printStackTrace();
            }

        } return c;
    }

    public double divide2Number() throws Exception {
        double c;
        c = AppManager.divide2Number();
        if (AppManager.h == 0) {
            throw new Exception("Divided by zero!");
        } else {
            return c;
        }
    }

    public String server_ping() throws Exception{
        String c;
        c = AppManager.server_ping();
        return c;
    }

    @Override
    public String getStatus() throws Exception {
        String c;
        c = AppManager.getStatus();
        return c;
    }

    public String[] getNum() {
        return array;
    }

}
