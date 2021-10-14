import java.util.concurrent.Semaphore;

public class MultithreadingPrintOddEven {

    /*
    A semaphore allows access to a shared resource
    through the use of a counter
    if counter is zero access is denied
    if counter greater than 0 access granted
     */
    public static void main(String[] args) throws InterruptedException {

        int n = 20;

        Semaphore even = new Semaphore(1);
        Semaphore odd = new Semaphore(0);

        //sem.acquire() will wait unless no permits in available

        Runnable r1 = () -> {
            for(int i=0;i<=n;i+=2) {
                try {
                    even.acquire();
                    System.out.println(Thread.currentThread().getName() + " -> " + i);
                    odd.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Runnable r2 = () -> {
            for(int i=1;i<=n;i+=2) {
                try {
                    odd.acquire();
                    System.out.println(Thread.currentThread().getName() + " -> " + i);
                    even.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);

        t1.start();
        t2.start();
    }
}
