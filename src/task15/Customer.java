package task15;

public class Customer implements Runnable {
    @Override
    public void run() {
        try {
            Store.state();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
