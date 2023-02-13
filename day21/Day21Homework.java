package day21;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static day21.ShapeTest.findShapes;

class Shape {
    private String type;
    private String color;
    private Double area;

    public Shape(String type, String color, Double area) {
        this.type = type;
        this.color = color;
        this.area = area;
    }

    public String getType() {
        return type;
    }

    public String getColor() {
        return color;
    }

    public Double getArea() {
        return area;
    }

    public String toString() {
        return type + "(" + color + ", " + area + ")";
    }

    public static final ArrayList<Shape> shape = new ArrayList<>(Arrays.asList(
            new Shape("삼각형", "빨간색", 10.5), new Shape("사각형", "파란색", 11.2),
            new Shape("원", "파란색", 16.5), new Shape("원", "빨간색", 5.3),
            new Shape("원", "노란색", 8.1), new Shape("사각형", "파란색", 20.7),
            new Shape("삼각형", "파란색", 3.4), new Shape("사각형", "빨간색", 12.6)
    ));
}


class ShapeTest {
    static List<Shape> findShapes(List<Shape> shape, String type, String color, Double area) {
        List<Shape> shape1 = new ArrayList<>();
        for (Shape types_colors_areas : shape) {
            if (types_colors_areas.getType().equals(type)) {
                shape1.add(types_colors_areas);
            } else if (types_colors_areas.getColor().equals(color) && types_colors_areas.getArea() <= area)
                shape1.add(types_colors_areas);
        }
        return shape1;
    }
}

public class Day21Homework {
    public static void main(String[] args) {
        List<Shape> find_type = findShapes(Shape.shape, "사각형", "", 0.0);
        System.out.println("사각형 : " + find_type);

        List<Shape> find_color_area = findShapes(Shape.shape, "", "빨간색", 12.0);
        System.out.println("빨간 도형(면적<=12.0) : " + find_color_area);
    }

}
