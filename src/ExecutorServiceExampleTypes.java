import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ExecutorServiceExampleTypes {

    public static void main(String[] args) throws InterruptedException {

        //uses linked blocking queue
        ExecutorService service1 = Executors.newFixedThreadPool(10);
        service1.execute(new Task());

        //uses linked blocking queue
        ExecutorService service4 = Executors.newSingleThreadExecutor();

        // uses synchronous queue which stores 1 task at a time
        ExecutorService service2 = Executors.newCachedThreadPool();

        for(int i=0;i<100;i++) {
            service2.execute(new Task());
        }

        // uses delayed work queue
        ScheduledExecutorService service3 = Executors.newScheduledThreadPool(10);


        // task to run after 10 seconds delay
        service3.schedule(new Task(), 10, TimeUnit.SECONDS);

        //task to run repeatedly every 10 seconds
        service3.scheduleAtFixedRate(new Task(), 15, 10, TimeUnit.SECONDS);

        //task to run repeatedly 10 seconds after previous task completes
        service3.scheduleWithFixedDelay(new Task(), 15, 10, TimeUnit.SECONDS);


        //initiate shutdown
        service1.shutdown();

        // will throw RejectionExecutionException
        //service.execute(new Task());


        // will return true, since shutdown has begun
        service1.isShutdown();


        //will return true if all task are completed
        //including queued ones
        service1.isTerminated();

        // throws InterruptedException
        // blocked until all tasks are completed or if timeout occurs
        service1.awaitTermination(10, TimeUnit.SECONDS);



        //will initiate shutdown and return all the queued task
        List<Runnable> runnables = service1.shutdownNow();







    }

    static class Task implements Runnable {

        @Override
        public void run() {
            System.out.println("Any task");
        }
    }
}
