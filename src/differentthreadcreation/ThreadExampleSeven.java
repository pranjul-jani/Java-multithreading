package differentthreadcreation;

import static differentthreadcreation.daemonthread.ThreadExampleSix.sleep;

/*
join a thread - wait for a thread to terminate
 */
public class ThreadExampleSeven {

    public static void main(String[] args) {
        Runnable runnable = () -> {
            for (int i = 0; i < 5; i++) {
                sleep(1000);
                System.out.println("Running");
            }
        };

        Thread t = new Thread(runnable);
        t.setDaemon(true);
        t.start();

        // if this is not done program will terminate immediately, but if we don't do it
        // then main thread will wait for the thread to complete its task
        try {
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}

