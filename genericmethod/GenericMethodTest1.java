package genericmethod;

public class GenericMethodTest1 {
    static class Prints {
        public static <T> void printArray(T[] arr) { // Generic code 하나로 type을 다양하게 사용할 수 있음.
            for (T a : arr)
                System.out.println(a);
        }

        public static <T> T getFirst(T[] arr) {
            return arr[0];
        }
    }


    public static void main(String[] args) {
        Double[] d1 = {3.14, 2.71, 9.9};
        Character[] d2 = {'A', 'B', 'C'};
        Prints.printArray(d1); // type을 유추해서 출력함
        System.out.println(Prints.getFirst(d2));
    }
}
