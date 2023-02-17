package NetworkPractice;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientExample {
    public static void main(String[] args) {
        try{
            Socket socket = new Socket("localhost", 5000);
            System.out.println("클라이언트 연결 성공");

            socket.close();
            System.out.println("클라이언트 연결 끊음");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
