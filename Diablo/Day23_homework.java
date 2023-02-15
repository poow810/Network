package Diablo;

import java.util.List;
import java.util.stream.Stream;

public class Day23_homework {
    public static void main(String[] args) {
        List<String> names = List.of("홍길동", "배장화", "임꺽정", "연흥부", "김선달", "황진이");
        Stream<String> stream = names.stream();
        stream.filter(n -> n.charAt(0) < '이').forEach(n -> System.out.print(n+" "));
        System.out.println();

        stream = names.stream();
        stream.sorted().forEach(n -> System.out.print(n+ " "));
        System.out.println();

        stream = names.stream();
        System.out.println(names.stream().findFirst());
        System.out.println(names.stream().findFirst().get());
        System.out.println(stream.count());
    }
}
