package FirstWay;

import java.util.concurrent.Semaphore;

public class Philosopher extends Thread{
    private final int id;
    private final Semaphore leftChopstick;
    private final Semaphore rightChopstick;

    public Philosopher(int id, Semaphore leftChopstick, Semaphore rightChopstick) {
        this.id = id;
        this.leftChopstick = leftChopstick;
        this.rightChopstick = rightChopstick;
        this.start();
    }

    @Override
    public void run() {
        try {
            while(true) {
                think();
                if (id % 2 == 0) {
                    eat(leftChopstick, rightChopstick);
                } else {
                    eat(rightChopstick, leftChopstick);
                }
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private void think() throws InterruptedException {
        System.out.println("FirstWay.Philosopher " + id + " is thinking");
        Thread.sleep(2000);
    }

    private void eat(Semaphore leftChopstick, Semaphore rightChopstick) throws InterruptedException {
        leftChopstick.acquire();
        rightChopstick.acquire();

        System.out.println("FirstWay.Philosopher " + id + " is eating.");
        Thread.sleep(3000);

        leftChopstick.release();
        rightChopstick.release();
    }
}
