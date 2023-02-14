package second;

public class GenericMethodTest2 {
    static class Prints {
        public static <T extends Number> void printArray(T[] arr) { // Generic code 하나로 type을 다양하게 사용할 수 있음.
            for (T a : arr)
                System.out.println(a);
        }
    }


    public static void main(String[] args) {
        Double[] d1 = {3.14, 2.71, 9.9};
        String[] d2 = {"Hi", "Hello"};
        Integer[] i1 = {10, 9, 7};
    }
}
