package collection;

import javax.xml.transform.SourceLocator;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class CollectionDemo3 {
    public static void main(String[] args) {
        Stack<Integer> s1 = new Stack<>();
        s1.push(5);
        s1.push(3);
        s1.push(1);

        System.out.println(s1.pop());
        System.out.println(s1.peek());

    }
}
