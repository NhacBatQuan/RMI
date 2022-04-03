package server;
import server.service.RMIServiceImpl;

import java.io.IOException;
import java.rmi.RemoteException;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static server.Calculation.array;


public class AppManager extends Thread implements Runnable{
    public static double g = Server.a;
    public static double h = Server.b;
    public static int count = 0;
    private boolean stopRequested = false;
    static Calculation calculationJob;

    public static String getStatus() {
        return null;
    }

    public synchronized void requestStop(){
        this.stopRequested = true;
    }
    public synchronized boolean isStopRequested(){
        return this.stopRequested;
    }

    static {
        try {
            calculationJob = new Calculation();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    private RMIServiceImpl service;

    public static String storagePath = null;
    public static String inputData = null;
    public static String calculationMethod = null;
    public AppManager() throws Exception {
        super();

        try {
           array();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void run() {
        try {
            calculationJob.Run();
            calculationJob.WriteCSV(Calculation.dataLines);
            try {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void requestCalculation(String scriptPath) throws Exception {
        long start = System.currentTimeMillis();
        //Setup custom calculation
//        Class Calculation = loadClass.getClass("./server_storage/Calculation.class");
//        "./src/main/java/server/Calculation.class"
//        Object obj_Calculation = Calculation.newInstance();
//        Calculation.getMethod("Run", null).invoke(obj_Calculation, null);

//        RunShellCommandFromJava.exec("java -cp "+storagePath+scriptPath+" "+calculationMethod+"main "
//                +storagePath+inputData+"Data.csv "+storagePath+"/result/result_server.csv");
//        scriptPath = 3;
        Thread thread1 = new AppManager();
        Thread thread2 = new AppManager();
        thread1.start();
        calculationJob.Timelapse();
        thread1.sleep(20000);
//        storagePath = "/Users/morpheus/Documents/Code/USTH/protech/RMI/webService/RMI/";
//        inputData = "/InputData/";
//        calculationMethod = "/CalculationMethod/";
//        RunShellCommandFromJava.exec("java -cp "+storagePath+3+calculationMethod+" main "+storagePath+3+inputData+"Data.csv "+storagePath+3+"/result/result_server.csv");
        thread1.sleep(1000);
        long elapsedTime = (long) calculationJob.ElapsedTime();
//        try {
//            if (elapsedTime > 5000) {
//                thread1.currentThread().interrupt();
//            }
//            if (Thread.interrupted()) {
//                throw new InterruptedException();
//            }
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }


//        System.out.println(elapsedTime / 1000 + " seconds");

//                "java ./server_storage/main ./server_storage/Data.csv ./server_storage/result_server.csv");
//        static Calculation calculationJob;
        //Calculation validation
//        Calculation calculationJob = new Calculation();;
//        calculationJob.Run();

        //Calculation method save to server (per user)
        //Booking calculation to queue
//        calculationJob.Run();

//        try {
//            scriptPath.split("/");
//            String[] name = scriptPath.split("/");
//            RunShellCommandFromJava.main("./" + name[name.length-1]);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }


    public static double plusArray() throws IOException {
        double c = Calculation.plusArray();
        return c;
    }

    public static double plus2Number() throws RemoteException {
        double c = Calculation.plus2Number();
        return c;
    }

    public static void time(long end) throws IOException, InterruptedException {
         Calculation.TimeCSV(end);
    }

    public static double minus2Number() throws RemoteException {
        double c = Calculation.minus2Number();
        return c;
    }

    public static double multiple2Number() throws RemoteException {
        double c = Calculation.multiple2Number();
        return c;
    }

    public static double divide2Number() throws Exception {
        double c = Calculation.divide2Number();
        return c;
    }

    public static String server_ping() throws Exception {
        String c = Calculation.server_ping();
        return c;
    }
}

