//package day25;
//
//import netscape.javascript.JSObject;
//
//import java.io.DataInputStream;
//import java.io.DataOutputStream;
//import java.io.IOException;
//import java.net.Socket;
//import java.util.Scanner;
//
//import org.json.JSONObject;
//
//public class ProductClient {
//    private Socket socket;
//    private Scanner scanner;
//    private DataInputStream dis;
//    private DataOutputStream dos;
//    public ProductClient(){
//        // 서버 소켓 생성후, 5000번 포트로 연결
//            Socket socket = new Socket("localhost", 5000);
//            dis = new DataInputStream(socket.getInputStream());
//            dos = new DataOutputStream(socket.getOutputStream());
//            System.out.println("클라이언트 연결 성공");
//            Scanner scanner = new Scanner(System.in);
//            list();
//        }
//    public void stop(){
//        try{// 소켓 닫기
//            socket.close();
//            System.out.println("클라이언트 연결 끊음");
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }
//    public void menu(){
//        System.out.println();
//        System.out.println("----------------------------");
//        System.out.println("메뉴: 1.Create | 2.Update | 3.Delete | 4.Exit");
//        System.out.println("선택: ");
//        String selectNo = scanner.nextLine();
//
//        switch (selectNo){
//            case "1" -> create();
//            case "2" -> update();
//            case "3" -> delete();
//            case "4" -> exit();
//        }
//    }
//    public void list(){
//        System.out.println();
//        System.out.println("-----------------------");
//        System.out.printf("%-5s%-30s%-15s%-10s\n", "no", "name", "price", "stock");
//        System.out.println("-----------------------"));
//
//        // 상품 목록 요청
//        JSONObject request = new JSONObject();
//        request.put("menu", 0);
//        request.put("data", new JSObject());
//        dos.writeUTF(request.toString());
//        dos.flush();
//    }
//    JSONObject response = new JSONObject(dis.readUTF());
//    if(response.getString("status").equals("success")){
//        JSONArray data = response.getJSONArray("data");
//
//    }
//    public void create(){ // 상품 생성 출력 메소드
//        System.out.println("[상품 생성]");
//        Product product = new Product();
//        System.out.println("상품 이름: ");
//        product.setName(scanner.nextLine());
//        System.out.println("상품 번호: ");
//        product.setNo(Integer.parseInt(scanner.nextLine()));
//        System.out.println("이름 변경: ");
//        product.setPrice(scanner.nextLine());
//        System.out.println("가격 변경: ");
//        product.setPrice(Integer.parseInt(scanner.nextLine()));
//        System.out.println("재고 변경: ");
//        product.setStock(Integer.parseInt(scanner.nextLine()));
//
//        // 상품 생성 요청
//        JSONObject data = new JSONObject();
//        data.put("name", product.getName());
//        data.put("price", product.getPrice());
//        data.put("stock", product.getStock());
//
//        JSONObject request = new JSONObject();
//        request.put("menu", 1);
//
//    }
//}
