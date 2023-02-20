package NetworkPractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;


public class PracticeServer {
    public static void main(String[] args) {
        System.out.println("Simple Echo Server");
        try (ServerSocket serverSocket = new ServerSocket(6000)) {
            System.out.println("Waiting for connection.....");
            Socket clientSocket = serverSocket.accept();
            System.out.println("Connected to client");

            BufferedReader br = null;
            PrintWriter out = null;

            try {
                br = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                out = new PrintWriter(clientSocket.getOutputStream(), true);
                String inputLine;
                while ((inputLine = br.readLine()) != null) {
                    System.out.println("Server: " + inputLine);
                    out.println(inputLine); // 서버에서 클라이언트로 송신
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            } finally{
                if (br != null) {
                    br.close();
                }
                if (out != null) {
                    out.close();    // 스트림 닫아줘야함
                }
            }
        } catch (IOException e) {
            System.out.println("접속 실패");
        }
    }
}