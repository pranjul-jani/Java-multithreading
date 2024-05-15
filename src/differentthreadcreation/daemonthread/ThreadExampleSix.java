package differentthreadcreation.daemonthread;

public class ThreadExampleSix {

    public static void main(String[] args) {
        Runnable runnable = () -> {
            while(true) {
                sleep(1000);
                System.out.println("Running");
            }
        };

        //this thread will keep on going even if the main thread has terminated, if setDaemon(true) is not set
        Thread thread = new Thread(runnable);
        thread.setDaemon(true);
        thread.start();
        sleep(3100);

    }

    public static void sleep(long millis) {
        try{
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
