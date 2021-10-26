import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class FakeConnectionDriver {

    public static void main(String[] args) throws InterruptedException {

        // executor.submit will create a new thread
        ExecutorService executorService = Executors.newCachedThreadPool();

        for(int i=0;i<200;i++) {
            executorService.submit(() -> FakeConnection.getInstance().connect());
        }
        executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.DAYS);
    }

}
