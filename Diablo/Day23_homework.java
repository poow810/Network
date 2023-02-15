package Diablo;

import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

enum Gender{
    남, 여;
}


public class Day23_homework {
    public static void main(String[] args) {

        List<Integer> ages = List.of(25, 20, 29, 28, 32, 18);
        List<Gender> genders = List.of(Gender.남, Gender.여, Gender.남, Gender.남, Gender.남, Gender.여);

        Stream<Integer> stream = ages.stream();
        System.out.println(stream.reduce(0, Integer::sum));
        stream = ages.stream();
        System.out.println(stream.max(Integer::compareTo).get());
        stream = ages.stream();
        System.out.println(
                ages.stream()
                        .mapToInt(n->n.intValue())
                        .average()
                        .getAsDouble()
        );
    }
}
