package NetworkPractice;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class PracticeClient {
    public static void main(String[] args) {
        System.out.println("심플 에코 클라이언트");
        PrintWriter pw = null;
        BufferedReader br = null;
        try {
            System.out.println("연결 대기 중");
            InetAddress localAdress = InetAddress.getLocalHost();
            try {
                Socket clientSocket = new Socket(localAdress, 6000);
                pw = new PrintWriter(clientSocket.getOutputStream(), true);
                br = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                System.out.println("서버와 연결됨");
                Scanner in = new Scanner(System.in);
                while (true) {
                    System.out.println("Enter text : ");
                    String inputLine = in.nextLine();
                    if ("quit".equalsIgnoreCase(inputLine)) {
                        break;
                    }
                    System.out.println(inputLine);
                    String response = br.readLine();
                    System.out.println(response);
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        } finally {
            if (pw != null) {
                pw.close();
            }
            try {
                if (br != null) {
                    br.close();
                }
            } catch (IOException e) {
            }
        }
    }
}