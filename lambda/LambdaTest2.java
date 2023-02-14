package lambda;

interface Calc{
    double calculate(double b);

}
// lambda expression
// x -> Integer.parseInt(x)
// method reference
// Integer::parseInt

// 정적 메서드 참조
// 클래스 이름::정적메서드
// 인스턴스 메서드 참조
// 객체 이름::인스턴스메서드
// 생성자 참조
// 클래스 이름::new
// 배열타입이름::new
interface Gets{
    char get(String s, int i);
}


public class LambdaTest2 {
    public static void main(String[] args) {
        Calc c;
        Gets g;

        // lambda type
        // c = (d) -> {return Math.abs(d);};
        // static method reference
        c = Math::abs;
        System.out.println(c.calculate(-9.9));

        // lambda
        // g = (a, b) -> a.charAt(b)
        g = String::charAt;
        System.out.println(g.get("Hello My friend !!", 4));
    }
}
