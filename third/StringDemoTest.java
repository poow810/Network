package third;

import java.util.Arrays;
import java.util.Comparator;

public class StringDemoTest {
    public static void main(String[] args) {
        String[] strings = {"Hi", "Hello friend", "Hello friend professor"};

        // 문자열 길이순으로 정렬
//        Arrays.sort(strings, new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                return o1.length() - o2.length();
//            }
        Arrays.sort(strings, (o1, o2) -> o1.length() - o2.length()); // 람다식

        for(String s : strings)
            System.out.println(s);
    }
}
