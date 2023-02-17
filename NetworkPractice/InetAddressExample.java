package NetworkPractice;


import java.net.UnknownHostException;
import java.net.InetAddress;
// IP 주소 얻기
public class InetAddressExample {
    public static void main(String[] args) {
        try{
            InetAddress local = InetAddress.getLocalHost();
            System.out.println("내 컴퓨터 IP 주소 : "+ local.getHostAddress()); // 로컬 컴퓨터의 IP 얻어오기

            InetAddress[] iaArr = InetAddress.getAllByName("www.naver.com"); // Domain 이름으로 등록된 모든 IP 주소
            for(InetAddress remote : iaArr) {
                System.out.println("www.naver.com IP 주소 : " + remote.getHostAddress()); // 배열로 가져옴
            }

            }catch (UnknownHostException e){
            e.printStackTrace();
        }
    }


}
