import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

public class ExecutorServiceExampleCallable {
    public static void main(String[] args) {

        ExecutorService service = Executors.newFixedThreadPool(10);

        List<Future<Integer>> allFutures = new ArrayList<>();
        for(int i=0;i<10;i++) {
            Future<Integer> future = service.submit(new Task());
            allFutures.add(future);
        }

        // 10 futures with 10 placeholders but not actual values as of now

        //perform some unrelated task

        for (int i=0;i<10;i++) {
            Future<Integer> future = allFutures.get(i);
            try {
                // blocking operation until future is ready to provide the value
                Integer result = future.get();

                // cancel the task
                future.cancel(false);

                // Returns true if the task was cancelled or otherwise
                future.isCancelled();

                // returns true if task is completed successfully or otherwise
                future.isDone();

                System.out.println("Result from task is " + i + " = " + result);
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }


    }

    static class Task implements Callable<Integer> {
        @Override
        public Integer call() throws Exception {
            Thread.sleep(2000);
            return new Random().nextInt();
        }
    }
}
