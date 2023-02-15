package Diablo;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

enum Gender{
    남, 여;
}

class Member{
    String name;
    Gender gender;
    int age;

    public Member(String name, Gender gender, int age) {
        this.name = name;
        this.gender = gender;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public Gender getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }
    public String toString(){
        return String.format("Member(%s, %s, %d)", name, gender, age);
    }
}


public class Day23_homework {
    static int i = 0;
    public static void main(String[] args) {
        List<String> names = List.of("홍길동", "배장화", "임꺽정", "연흥부", "김선달", "황진이");
        List<Integer> ages = List.of(25, 20, 29, 28, 32, 18);
        List<Gender> genders = List.of(Gender.남, Gender.여, Gender.남, Gender.남, Gender.남, Gender.여);

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

        Stream<Integer> streams = ages.stream();
        System.out.println(streams.reduce(0, Integer::sum));
        streams = ages.stream();
        System.out.println(streams.max(Integer::compareTo).get());
        streams = ages.stream();
        System.out.println(
                ages.stream()
                        .mapToInt(n->n.intValue())
                        .average()
                        .getAsDouble()
        );

        stream = names.stream();
        Stream<Member> sm = stream.map(n -> new Member(n, genders.get(i), ages.get(i++)));
        sm.forEach(m -> System.out.print(m + " "));
        System.out.println();

        i = 0;
        stream = names.stream();
        sm = stream.map(n -> new Member(n, genders.get(i), ages.get(i++)));
        Map<Gender, List<Member>> map = sm.collect(Collectors.groupingBy(Member::getGender));
        System.out.println(map);
    }
    }
