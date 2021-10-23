import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceExample {

    public static void main(String[] args) {

        // create pool
        ExecutorService service = Executors.newFixedThreadPool(10);

        // submit task for execution
        for(int i=0;i<100;i++) {
            service.execute(new Task());
        }

        System.out.println(" Thread name -> " + Thread.currentThread().getName());

    }

    static class Task implements Runnable {

        @Override
        public void run() {
            try {
                Thread.sleep(1000);
            }catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("Thread name -> " + Thread.currentThread().getName());
        }
    }
}
