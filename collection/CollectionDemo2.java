package collection;

import java.util.Arrays;
import java.util.List;

public class CollectionDemo2 {
    public static void main(String[] args) {
        String[] soldiers1 = {"박민석123", "차병호12", "김상훈1", "최일구1243"};

        List<String> soldiers2 = Arrays.asList(soldiers1);
        soldiers2.set(1, "성윤모");

        for(String s : soldiers2)
            System.out.print(s + " ");
        System.out.println();

        soldiers2.sort((s1, s2) -> s1.length()-s2.length());
        String[] soldiers3 = soldiers2.toArray(new String[0]);
        for(int i = 0; i < soldiers3.length; i++)
            System.out.print(soldiers3[i] + " ");
        System.out.println();

        List<String> grades = List.of("이병", "일병", "상병", "병장");
        grades.forEach(g -> System.out.println(g + " "));

    }
}
