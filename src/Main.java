import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args) {

        Semaphore[] chopsticks = new Semaphore[5];
        for (int i = 0; i < 5; i++) {
            chopsticks[i] = new Semaphore(1);
        }

        Philosopher[] philosophers = new Philosopher[5];
        for (int i = 0; i < 5; i++) {
            Semaphore leftChopstick = chopsticks[i];
            Semaphore rightChopstick = chopsticks[(i + 1) % 5];
            philosophers[i] = new Philosopher(i, leftChopstick, rightChopstick);
        }
    }
}