package task15;

import java.time.Duration;
import java.time.LocalDateTime;

public class Store implements Runnable {
    static int count = 0;
    static int iterator = 30;
    static boolean state;

    @Override
    public void run() {
        LocalDateTime start = LocalDateTime.now();
        while (true) {
            state = true;
            LocalDateTime end = LocalDateTime.now();
            Duration between = Duration.between(start, end);
            if (between.toSeconds() == iterator) {
                System.out.println("Перерыв");
                state = false;
                iterator += iterator + 10;
                count = 0;
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Конец перерыва");
            }
        }
    }

    static void state() throws InterruptedException {
        if (state && count < 5) {
            count++;
            int counterClient = 0;
            int maxTime = 100;
            int time = ((int) (1 + Math.random() * 9) * 10);
            System.out.println("Новый посетитель");
            while (true) {
                if (state) {
                    Thread.sleep(time);
                    counterClient++;
                } else {
                    System.out.println("Посититель вышел, перерыв");
                    count--;
                    break;
                }
                if (counterClient == maxTime) {
                    System.out.println("Посититель покинул магазин");
                    count--;
                    break;
                }
            }

        } else {
            System.out.println("Магазин переполнен или закрыт");
        }
    }
}