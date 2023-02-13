package day21;

public class Node {
    public String data;
    public Node link;   // 자기 자신의 주소를 받아야함 : day21.Node

    @Override
    public String toString() {      // 최상위 클래스인 object를 오버라이드
        return "노드의 데이터 값은 " + data + "입니다.";
    }
}
