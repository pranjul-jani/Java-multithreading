import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockExecutorService {
    private static final int THREAD_COUNT = 5;
    private static final int TASK_COUNT = 10;

    private static ReadWriteLock rwLock = new ReentrantReadWriteLock();

    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(THREAD_COUNT);

        for (int i = 0; i < TASK_COUNT; i++) {
            service.execute(() -> performWriteTask());
            service.execute(() -> performReadTask());
        }

        service.shutdown();
    }

    private static void performWriteTask() {
        rwLock.writeLock().lock();
        try {
            System.out.println("Step 1 (Write) by " + Thread.currentThread().getName());
//            Thread.sleep(3000); // Simulating some write operation
            System.out.println("Step 2 (Write) by " + Thread.currentThread().getName());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            rwLock.writeLock().unlock(); // Release write lock
        }
    }

    private static void performReadTask() {
        // Performing read operation
        rwLock.readLock().lock(); // Acquire read lock for reading
        try {
            System.out.println("Reading data by part 1 " + Thread.currentThread().getName());
//            Thread.sleep(3000);
            System.out.println("Reading data by part 2 " + Thread.currentThread().getName());
            // Simulating some read operation
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            rwLock.readLock().unlock(); // Release read lock
        }
    }

}
