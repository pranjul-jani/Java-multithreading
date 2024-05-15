package memorymodel;

public class SharedRunnable implements Runnable {

    @Override
    public void run() {
        int count = 0;
        for (int i=0;i<1_000_000;i++) {
//            synchronized (this) {
                count++;
//            }
        }
        System.out.println(Thread.currentThread().getName() + " : " + count);
    }
}
