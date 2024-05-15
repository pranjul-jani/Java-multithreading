package differentthreadcreation.lamdaexpression;

public class ThreadExampleFour {
    public static void main(String[] args) {
        Runnable runnable = () -> {
            String threadName = Thread.currentThread().getName();
            System.out.println(threadName +  "running");

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(threadName + "finished");
        };

        Thread thread = new Thread(runnable, "Thread A");
        thread.start();
        Thread thread2 = new Thread(runnable, "Thread B");
        thread2.start();
    }
}
