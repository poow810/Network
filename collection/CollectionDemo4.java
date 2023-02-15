package collection;
// Map
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class CollectionDemo4 {
    public static void main(String[] args) {
        Map<String, Integer> soldiers = Map.of("최일구", 4, "김상훈", 3, "박민석", 2, "차병호", 1, "성윤모", 1);

        for(String idx : soldiers.keySet())
            System.out.println(idx+"는 작대기가 " + soldiers.get(idx) + "개 입니다");

        Map<String, Integer> soldiers2 = new HashMap<>(soldiers);
        soldiers2.put("심우진", 4);
        for(String idx : soldiers2.keySet())
            System.out.println(idx+"는 작대기가 " + soldiers.get(idx) + "개 입니다");
    }
}