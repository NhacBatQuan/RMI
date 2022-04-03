package server;

//import server.service.RMIServiceImpl;

import org.json.JSONArray;
import org.json.JSONObject;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.imageio.metadata.IIOMetadataNode;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Arrays;
import java.io.*;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
//import static org.graalvm.compiler.debug.DebugOptions.Log;
//import static org.graalvm.compiler.debug.DebugOptions.Log;

public class Calculation extends AbstractCalculation {
//    private RMIServiceImpl service;
    public static double a = AppManager.g;
    public static double b = AppManager.h;

    public static long start = 0;
    public static long end = start + 7200*1000;
    public static long finish;

    public static String status;
    public static String[] array = new String[15];
    public static String[] f;
    public static double[] numbers;
    public static ArrayList<Double> dataLines = new ArrayList<>();
    public static boolean done;
//    AbstractCalculation calculationJob;
    public Calculation() throws RemoteException {
        super();
//        this.service = new RMIServiceImpl();
    }

    @Override
    public String getData(){

        return "validated Data";
    }
    public static String getSta() throws RemoteException {
        String calculationStatus = getStatus();
        return calculationStatus;
    }

    @Override
    public void Run() throws IOException {
        try {
            double result = plusArray();
            done = TRUE;
            String calculationStatus = "done";
            System.out.println("Server done!");
            System.out.println(result);
            dataLines.add(
                    result);
//            .addAll(Arrays.asList(question2));
            String savedResult = WriteCSV(dataLines);
        }catch (IOException e) {
            e.printStackTrace();
        }
        return;
    }

    public static double plus2Number() {
        double c = a+b;
        AppManager.count++;
        return c;
    }

    public static void setPath(String path) throws RemoteException {
        setPath(path);
    }
    public static void cancel (){
        try {
            throw new InterruptedException();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static String getPath(String text) throws RemoteException {
        setPath(text);
        System.out.println(text);
        return text;
    }

    public static String getStatus() throws RemoteException{
        if (done == TRUE){
            RMISpring.calculationStatus = "done";
            System.out.println(RMISpring.calculationStatus);
        }
        if (done == FALSE){
            RMISpring.calculationStatus = "calculating";
            System.out.println(RMISpring.calculationStatus);
        }
        return status;
    }

    public static double minus2Number() {
//        done = TRUE;
        double c = a-b;
        AppManager.count++;
        return c;
    }
    public static double multiple2Number() {
//        done = TRUE;
        AppManager.count++;
        double c = a*b;
        return c;
    }
    public static double divide2Number() throws Exception {
//        done = TRUE;
        AppManager.count++;
        double c = a/b;
        if (b == 0) {
            throw new Exception("Divided by zero!");
        } else {
            return c;
        }
    }
    public static double[] array() throws IOException {
        ReadXml();

        ReadCSV();
        f = array;
        numbers= Arrays.stream(f).filter(Objects::nonNull).mapToDouble(Double::valueOf).toArray() ;
//        numbers= Arrays.stream(f).mapToDouble(Double::valueOf).toArray();
        return numbers;
    }

    public static double plusArray() throws IOException {
        double e = 0;
        for (int i = 0; i<numbers.length; i++){
            e += numbers[i];
        }
        done = TRUE;
        return e;
    }
    public static String server_ping() throws Exception{
        String c = "hello from the server side";
        return c;
    }
    // Read Data

//    public static String[] ReadXml() throws IOException{
//        String xmlFile = new String(Files.readAllBytes(Paths.get("D:\\Skeleton\\ProjectRMi\\xml.xml")));
//
//        return new String[0];
//    }

    public static String ReadXml(){
        String path1 = "D:\\Skeleton\\ProjectRMi\\Client1\\Data1";
        String path = path1 + "\\Data.xml";
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            try {
                DocumentBuilder builder = factory.newDocumentBuilder();
                Document document = builder.parse(new File(path));

                document.getDocumentElement().normalize();
                NodeList list = document.getElementsByTagName("Number");
                for (int i = 0; i < list.getLength(); i++) {
                    Node number = list.item(i);
                    if (number.getNodeType() == Node.ELEMENT_NODE) {
                        Element numberElement = (Element) number;
                        System.out.println(numberElement.getAttribute("Client"));

                        NodeList numberDetails = number.getChildNodes();

                        for (int j = 0; j < numberDetails.getLength(); j++) {
                            Node detail = numberDetails.item(j);
                            if (detail.getNodeType() == Node.ELEMENT_NODE) {
                                Element detailElement = (Element) detail;
//                            System.out.println("     " + detailElement.getTagName() + ": " + detailElement.getAttribute("value"));
                                array[j] = detailElement.getAttribute("value");
                            }
                        }
                    }
                }
            } catch (ParserConfigurationException ex) {
                ex.printStackTrace();
            } catch (IOException ex) {
                ex.printStackTrace();
            } catch (SAXException ex) {
                ex.printStackTrace();
            }
        return array[0];
    }

    public static String ReadJson() throws IOException {
        String path1 = "D:\\Skeleton\\ProjectRMi\\Client1\\Data1";
        String path = path1 + "\\Data.json";
         String carInfoJson = new String(Files.readAllBytes(Paths.get(path)));
            JSONArray myjson = new JSONArray(carInfoJson);

            int size = myjson.length();
            ArrayList<JSONObject> arrays = new ArrayList<JSONObject>();
            for (int i = 0; i < size; i++) {
                JSONObject another_json_object = myjson.getJSONObject(i);
                arrays.add(another_json_object);
            }
            JSONObject[] jsons = new JSONObject[arrays.size()];
            arrays.toArray(jsons);

            Object[] objects = arrays.toArray();

            for (int i = 0; i < arrays.size(); i++) {
                array[i] = (String.valueOf(arrays.get(i).get("Number")));
            }
        return array[0];
    }

    public static String ReadCSV() throws IOException {
        String path1 = "D:\\Skeleton\\ProjectRMi\\Client1\\Data1";
        String path = path1 + "\\Data.json";
        String line = "";
        if (path.endsWith(".csv")) {
            {
                try {
                    BufferedReader read = new BufferedReader(new FileReader(path));
                    for (line = read.readLine(); line != null; line = read.readLine()) {
                        array = line.split(",");
                    }
                    read.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        if (path.endsWith(".json")) {
            ReadJson();
        }

        if (path.endsWith(".xml")) {
            ReadXml();
        }
        return array[0];


    }

//    }
    public static double Timelapse() {
        start = System.currentTimeMillis();
        return start;
    }
    public static double ElapsedTime(){
        long finish = System.currentTimeMillis();
        long elapsed = finish - start;
        return elapsed;
    }

    public static void TimeCSV(long end) throws IOException, InterruptedException {
        String path = "D:\\Skeleton\\ProjectRMi\\Client1\\Result1\\time.txt";
        FileWriter writer = new FileWriter(path);
        BufferedWriter bw = new BufferedWriter(writer);
        bw.append(String.valueOf(end));
        bw.flush();
        bw.close();
    }

    public static String WriteCSV(ArrayList<Double> result) throws IOException {
        String path = "D:\\Skeleton\\ProjectRMi\\Client1\\Result1\\result.csv";
//        String path1 = AppManager.PathFinder + path;
        arraySave(path, result);
//        String savedResult = WriteCSV(dataLines);

        return "Done";
    }
    public String convertToCSV(String[] data) {
        return Stream.of(data)
                .map(this::escapeSpecialCharacters)
                .collect(Collectors.joining(","));
    }

    public String escapeSpecialCharacters(String data) {
        String escapedData = data.replaceAll("\\R", " ");
        if (data.contains(",") || data.contains("\"") || data.contains("'")) {
            data = data.replace("\"", "\"\"");
            escapedData = "\"" + data + "\"";
        }
        return escapedData;
    }


    public static void arraySave(String CSV_FILE_NAME,ArrayList<Double> data) throws IOException {
        File csvOutputFile = new File(CSV_FILE_NAME);
        try (PrintWriter pw = new PrintWriter(csvOutputFile)) {
            int datList = data.size();
            System.out.println("Saving ! ");
            for (int i = 0; i < datList; i++) {
                pw.write(String.valueOf(data.get(i)));
                System.out.println(String.valueOf(data.get(i)));
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
