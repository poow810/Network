package day22;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Day22_homework {
    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        int alphabet = 'a';
        Runnable task = () -> {
            try {
                for (int i = 0; i < 5; i++) {
                    System.out.println("작업 스레드 : " + i);
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };exec.execute(task);
        try {
            for (alphabet = 97; alphabet < 107; alphabet += 1) {
                System.out.println("메인 스레드 : " + (char) alphabet);
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }exec.shutdown();
    }
}