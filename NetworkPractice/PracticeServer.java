package NetworkPractice;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.*;

import static java.lang.System.out;

public class PracticeServer implements Runnable {
    private static Socket clientSocket;

    public PracticeServer(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    @Override
    public void run() {
        out.println("클라이언트 연결됨" + Thread.currentThread());
        try (
                BufferedReader br = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                PrintWriter pw = new PrintWriter(clientSocket.getOutputStream(), true)) {
            String inputLine;
            while ((inputLine = br.readLine()) != null) {
                out.println("클라이언트 요청" + Thread.currentThread() + inputLine);
                out.println(inputLine);
            }
            out.println("Client 연결됨" + Thread.currentThread());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


    public static void main(String[] args) {
        out.println("쓰레드 에코 서버 시작");
        try (
                ServerSocket serverSocket = new ServerSocket(6000)) {
            out.println("연결 기다리는중");
            clientSocket = serverSocket.accept();
            PracticeServer tes = new PracticeServer(clientSocket);
            new Thread(tes).start();
        } catch (IOException e) {
            out.println("오류 발생");
        }
    }
}