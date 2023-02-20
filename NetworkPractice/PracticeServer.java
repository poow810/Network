package NetworkPractice;


import java.io.IOException;
import java.net.*;
import java.util.Date;

public class PracticeServer {
    public static void main(String[] args) {
        System.out.println("멀티캐스트 타임 서버");
        DatagramSocket serverSocket = null;
        try{
            serverSocket = new DatagramSocket();
            while (true) {
                String dateText = new Date().toString();
                byte[] buffer = new byte[256];
                buffer = dateText.getBytes();

                InetAddress group = InetAddress.getByName("224.0.0.117");
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length, group, 10000);
                serverSocket.send(packet);
                System.out.println("전송된 시간: " + dateText);

                try{
                    Thread.sleep(5000);
                }catch (InterruptedException e){
                    throw new RuntimeException();
                }
            }

        } catch (IOException e) {
        }
    }
}