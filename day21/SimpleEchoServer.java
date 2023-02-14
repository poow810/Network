package day21;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class SimpleEchoServer implements Runnable { // 다중 접속 에코 서버
    private static Socket clientSocket;
    public SimpleEchoServer(Socket clientSocket){
        this.clientSocket = clientSocket;
    }
    public static void main(String[] args) {
        ExecutorService eService = Executors.newFixedThreadPool(2);
        System.out.println("다중 접속 에코 서버");

        try (ServerSocket serverSocket = new ServerSocket(20000)) {
            while (true) {
                System.out.println("클라이언트 접속 대기중");
                clientSocket = serverSocket.accept();
                SimpleEchoServer tes = new SimpleEchoServer(clientSocket);
                eService.submit(tes); // simpleechoserver가 run을 가지고 있으므로
            }
        } catch (IOException ex) {
            System.out.println("입출력 예외 발생");
        }
        System.out.println("다중 접속 에코 서버 종료");
        eService.shutdown();
    }

    @Override
    public void run() {
        System.out.println("["+ Thread.currentThread() + "] 스레드 : ");
        try (BufferedReader br = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
             PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)) {
            String inputLine;
            while ((inputLine = br.readLine()) != null) {
                System.out.println("[" + Thread.currentThread() + "클라이언트가 보낸 메세지 : " + "]: " + inputLine);
                out.println(inputLine);
            }
            System.out.println(Thread.currentThread() +" 클라이언트가 종료됨"); }
        catch (IOException ex) {
            System.out.println("입출력 예외 발생");
        }
    }
}
//        System.out.println("에코 서버 시작됨");
//        try (ServerSocket serverSocket = new ServerSocket(6001)) {
//            System.out.println("클라이언트 접속 대기 중...");
//            Socket clientSocket = serverSocket.accept(); // 접속 대기
//            System.out.println("클라이언트 접속됨");
//            try (
//                    BufferedReader br = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
//                    PrintWriter pw = new PrintWriter(clientSocket.getOutputStream(), true)) {
//                Stream
//                        .generate(() -> {
//                            try {
//                                return br.readLine();
//                            } catch (IOException ex) {
//                                return null;
//                            }
//                        })
//                        .peek(text -> {
//                            System.out.println("클라이언트로부터 받은 메세지 : " + text);
//                            pw.println(text); // 클라이언트로 송신
//                        }).allMatch(Objects::nonNull);
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//            }
//        } catch (IOException ex) {
//            System.out.println("접속 실패");
//
//        }
//    }
//}