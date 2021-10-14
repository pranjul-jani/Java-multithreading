import java.util.concurrent.Semaphore;

public class FakeConnection {

    private static FakeConnection instance;
    private int connections = 0;
    private Semaphore sem = new Semaphore(10);

    private FakeConnection() {
    }

    public static FakeConnection getInstance() {
        if (instance == null) {
            instance = new FakeConnection();
        }
        return instance;
    }

    public void connect() {
        try {
            sem.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            doConnect();
        } finally {
            sem.release();
        }
    }
    public void doConnect() {
        try {
            sem.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        synchronized (this) {
            connections ++;
            System.out.println(Thread.currentThread().getName() + " -> " + connections);
        }

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        synchronized (this) {
            connections --;
        }
        sem.release();
    }
}
