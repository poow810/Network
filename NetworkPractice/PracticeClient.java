package NetworkPractice;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class PracticeClient {
    public static void main(String[] args) {
        System.out.println("에코 클라이언트 실행");
        try {
            InetAddress localAddress = InetAddress.getLocalHost();
            Socket clientSocket = null;
            BufferedReader br = null;
            PrintWriter out = null;
            try {
                clientSocket = new Socket(InetAddress.getLocalHost(), 6000);
                br = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                out = new PrintWriter(clientSocket.getOutputStream(), true);

                System.out.println("서버에 연결됨");
                Scanner in = new Scanner(System.in);
                while (true) {
                    System.out.println("전송 메세지 입력 : ");
                    String line = in.nextLine();
                    if ("quit".equalsIgnoreCase(line)) {
                        break;
                    }
                    out.println(line);  // 클라이언트에서 서버로 전송
                    System.out.println("서버로부터 받은 메세지 : " + br.readLine());
                }
            } catch (IOException e) {
                System.out.println("입출력 예외 발생");
            } finally {
                if (clientSocket != null) {
                    clientSocket.close();
                }
                if (br != null) {
                    br.close();
                }
                if (out != null) {
                    out.close();
                }
            }
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }
}
