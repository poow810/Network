package Stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class StreamDemo8 {
    public static void main(String[] args) {
        List<Fruit> fruitList = Arrays.asList(
                new Fruit("watermelon", 16000),
                new Fruit("strawberry", 10000),
                new Fruit("kiwi", 13000),
                new Fruit("banana", 6000)
        );
        Stream<Fruit> st = fruitList.stream();
//        st.sorted().forEach(f -> System.out.println(f.getName() + " " + f.getPrice())); // sorted가 객체의 정렬 기준을 모름 : 기준 제시를 해주어야함.
        st.sorted((f1, f2) -> f2.compareTo(f1)).forEach((f-> System.out.println(f.getName()+ " " + f.getPrice())));
        // st.sorted(Comparator.naturalOrder()).forEach((f-> System.out.println(f.getName()+ " " + f.getPrice())));
        // st.sorted(Comparator.reverseOrder()).forEach((f-> System.out.println(f.getName()+ " " + f.getPrice())));
    }
}
