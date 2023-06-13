package juc.syn;

public class SynTest {
    public static void main(String[] args) {
        Fruits thread1 = new Fruits() {{
            setName("thread1");
        }};
        Fruits thread2 = new Fruits() {{
            setName("thread2");
        }};
        thread1.start();
        thread2.start();
    }
}


class Fruits extends Thread {
    static int fruits = 1000;
    static final Object LOCK = new Object();

    @Override
    public void run() {
        while (true) {
            boolean consume = consume();
            if (consume) break;
        }
    }

    public static synchronized boolean consume() {  //static 锁为class对象, 非static为this
        if (fruits <= 0) return false;
        System.out.println(Thread.currentThread().getName() + ": " + --fruits + "  remaining");
        return fruits <= 0;
    }
}

class Fruit implements Runnable {
    int count = 1000;
    @Override
    public void run() {
        while (true) {
            synchronized (this) {
                if (count == 0) break;
                System.out.println(Thread.currentThread().getName() + ": " + --count + "  remaining");
            }
        }
    }
}