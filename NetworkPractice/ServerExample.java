package NetworkPractice;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServerExample {
    private static ServerSocket serverSocket = null;

    public static void main(String[] args) {
        startServer();
        Scanner scanner = new Scanner(System.in);
        while(true){
            String key = scanner.nextLine();
            if(key.toLowerCase().equals("q")){
                break;
            }
        }
        scanner.close();
        stopServer();
    }

    private static void startServer() {
        Thread thread = new Thread(){
            public void run(){
                try{
                    serverSocket = new ServerSocket(5000);
                    System.out.println("서버 시작됨");

                    while(true){
                        System.out.println("서버 연결 요청을 기다림");
                        Socket socket = serverSocket.accept();

                        InetSocketAddress isa = (InetSocketAddress) socket.getRemoteSocketAddress();
                        System.out.println("서버 연결 요청 수락");

                        socket.close();
                        System.out.println("서버 연결 끊음");
                    }
                } catch (IOException e) {
                }
            }
        };
        thread.start();
    }

    private static void stopServer() {
        try{
            serverSocket.close();
            System.out.println("서버 종료됨");
        } catch (IOException ignored) {
        }
    }
}