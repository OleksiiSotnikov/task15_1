package task15;

import java.time.Duration;
import java.time.LocalTime;

public class Main {

    public static void main(String[] args) {
        Runnable shop = new Store();
        Thread shop1 = new Thread(shop);
        shop1.start();
        int iterator = (int) (2 + Math.random() * 6);
        LocalTime start = LocalTime.now();
        while (true) {
            LocalTime end = LocalTime.now();
            Duration duration = Duration.between(start, end);
            if (duration.toSeconds() == iterator) {
                iterator += (int) (2 + Math.random() * 6);
                Runnable c = new Customer();
                Thread b = new Thread(c);
                b.start();
            }
        }
    }
}
