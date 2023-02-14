package day22;

class Worker extends Thread {
    @Override
    public void run() {
        for (int i = 0; i<5; i++){
            System.out.println(i);
            try{
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}


public class Day22_homework {
    public static void main(String[] args) {
        int alphabet = 'a';
        Thread t = new Thread(new Worker());
        t.start();

        for (alphabet=97; alphabet<107; alphabet+=1) {
            System.out.println((char)alphabet);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }


        }
    }
}
