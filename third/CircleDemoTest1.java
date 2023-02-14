package third;

import javax.swing.plaf.metal.MetalIconFactory;
import java.util.Arrays;

class Circle implements Comparable{
    private double radius;

    public Circle(double radius){
        this.radius = radius;
    }
    public double getArea(){
        return Math.PI * radius * radius;
    }
    public String toString(){
        return "원의 반지름은 " + radius + "입니다";
    }

    @Override
    public int compareTo(Object o) {
        Circle c = (Circle)o;
        return (int)(getArea() - c.getArea());
    }
}

public class CircleDemoTest1 {
    public static void main(String[] args) {
        Circle[] circles = { new Circle(5.0), new Circle(2.5), new Circle(10.0)};

        Arrays.sort(circles); // 어떤 기준으로 정렬을 하라는지 알 수 없음
                              // implement로 기준을 정해주어야한다.

        for(Circle c : circles)
            System.out.println(c);
    }
}
