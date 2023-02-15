package Stream;

import java.util.stream.IntStream;

public class StreamDemo4 {
    private static int result;

    public static void main(String[] args) {
        IntStream st = IntStream.rangeClosed(1, 10);
        // st.forEach(System.out::println); // n-> System.out.println(n)이랑 같은 방식임
        st.forEach(n -> result += n);
        System.out.println(result);
    }
}
