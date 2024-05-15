package multithreadingexample;

public class SharedObject {
    boolean flag = false;

    synchronized void waitForFlagToChange() {
        if (!this.flag) {
            try {
                System.out.println("Thread has entered wait state " + Thread.currentThread().getName());
                wait();
                System.out.println("Thread has exited wait state " + Thread.currentThread().getName());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    synchronized void changeStateAndNotify() {
        this.flag = true;
        notify();
    }

    synchronized void changeStateAndNotifyAll() {
        this.flag = true;
        notifyAll();
    }
}
