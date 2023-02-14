package day22;

public class Day22_homework {
    public static void main(String[] args) {
        int alphabet = 'a';
        Thread t = new Thread(() -> {
            try {
                for (int i = 0; i < 5; i++) {
                    System.out.println("작업 스레드 : " + i);
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        t.start();
        try {
            for (alphabet = 97; alphabet < 107; alphabet += 1) {
                System.out.println("메인 스레드 : " + (char) alphabet);
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}