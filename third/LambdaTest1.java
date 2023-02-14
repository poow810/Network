package third;
//Lambda Expression (람다식)
//- 익명 메서드 (일반 메서드와 달리 이름이 없음)
//- 메서드와 달리 특정 클래스에 종속 x, 매개변수, 리턴타입, 본체를 가짐
//- 예외처리가 가능
//- 메서드의 인수로 전달될 수도 있고, 변수에 대입될 수도 있음.
//- 익명 구현 객체와 달리 메서드의 핵심 부분만 포함됨

// (타입 매개변수 ...) -> { 실행문; 실행문; ..}
interface Positive {
    int pos(int x);
}

interface Prints {
    void print();
}

public class LambdaTest1 {
    public static void main(String[] args) {
        Positive po;
        Prints pr;

        po = (int n) -> {
            return n + 1;
        };
        po = n -> {
            return n + 1;
        };
        po = (int n) -> n + 1;
        po = n -> n + 1;
        // 매개변수나 실행문이 하나일 경우 괄호, 중괄호 생략이 가능

        pr = () -> {
            System.out.println("Hi~");
        };
        pr = () ->
                System.out.println("Hi~");
    pr.print();
    }
}
