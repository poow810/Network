package Stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamDemo1{
    public static void main(String[] args) {
        List<String> cities = Arrays.asList("서울", "부산", "광주", "대구", "부산", "서울", "대전", "경기");
        Stream<String> stream = cities.stream();
        stream.forEach(c -> System.out.println(c+" "));
    }
}
