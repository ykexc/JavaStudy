package juc.thread;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class NewThread {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Thread t1 = new One(){{setName("one");}};
        Thread t2 = new One(){{setName("two");}};

        t1.start();
        t2.start();
        Two two = new Two();
        Thread t3 = new Thread(two, "three"), t4 = new Thread(two, "four");
        t3.start();
        t4.start();


        Callable<Integer> three = new Three();
        FutureTask<Integer> futureTask1 = new FutureTask<>(three);
        FutureTask<Integer> futureTask2 = new FutureTask<>(three);
        new Thread(futureTask1, "six").start();
        Thread.sleep(1000);
        new Thread(futureTask2, "five").start();

        Integer integer1 = futureTask1.get();
        Integer integer2 = futureTask2.get();
        System.out.println(integer1 + " " + integer2);
    }

}

class One extends Thread {
    @Override
    public void run() {
        Random random = new Random(System.currentTimeMillis());
        int i = random.nextInt(10);
        for (int j = 0; j < i; j++) {
            System.out.println(getName() + ": " + "hello-world");
        }
    }
}

class Two implements Runnable {
    @Override
    public void run() {
        Random random = new Random(System.currentTimeMillis());
        int i = random.nextInt(10);
        for (int j = 0; j < i; j++) {
            System.out.println(Thread.currentThread().getName() + ": " + "hello-world");
        }
    }
}

class Three implements Callable<Integer> {

    @Override
    public Integer call() {
        Random random = new Random(System.currentTimeMillis());
        int i = random.nextInt(10);
        for (int j = 0; j < i; j++) {
            System.out.println(Thread.currentThread().getName() + ": " + "hello-world");
        }
        return i;
    }
}
