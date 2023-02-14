import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class SelfClient {
    public static void main(String[] args) throws IOException {
        System.out.println("셀프 클라이언트 시작됨");
        InetAddress localAddress = InetAddress.getLocalHost();
        try{
            Socket clientSocket = null;
            PrintWriter pw = null;
            BufferedReader br = null;
            try{
                clientSocket = new Socket(InetAddress.getLocalHost(), 6000);
                pw = new PrintWriter(clientSocket.getOutputStream(), true); // 자동으로 출력
                br = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

                System.out.println("서버에 연결됨");
                Scanner in = new Scanner(System.in);
                while (true){
                    System.out.println("전송 메세지 입력 : ");
                    String line= in.nextLine();
                    if ("exit".equalsIgnoreCase(line)){
                        break;
                    }
                    pw.println(line); // 서버로 전송
                    System.out.println("서버로부터 받은 메세지 : " + br.readLine());
                }
            } catch (IOException e) {
                System.out.println("입출력 예외 발생");
            } finally {
                clientSocket.close();
                pw.close();
                br.close();
            }

        } catch (IOException e){
            throw new RuntimeException(e);
        }
    }
}
