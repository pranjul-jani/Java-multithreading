import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LocksAndExecutorService {
    private static final int THREAD_COUNT = 5;
    private static final int TASK_COUNT = 10;

    private static Lock lock = new ReentrantLock();

    public static void main(String[] args) {

        ExecutorService service = Executors.newFixedThreadPool(THREAD_COUNT);

        for (int i=0;i<TASK_COUNT;i++) {
            service.execute(() -> performTask());
        }

        service.shutdown();

    }

    private static void performTask() {
        lock.lock();
        try {
            System.out.println("Step 1 by " + Thread.currentThread().getName());
            Thread.sleep(3000);
            System.out.println("Step 2 by " + Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

}
