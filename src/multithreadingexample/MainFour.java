package multithreadingexample;

public class MainFour {

    public static ThreadLocal<SharedObject> sharedObjectThreadLocal = new ThreadLocal<SharedObject>(){
        @Override
        protected SharedObject initialValue() {
            return new SharedObject();
        }

        @Override
        public SharedObject get() {
            return super.get();
        }
    };

    public static void main(String[] args) {
//        SharedObject sharedObject = new SharedObject();

        final SharedObject so = sharedObjectThreadLocal.get();

        Runnable r1 = so::waitForFlagToChange;
        Runnable r2 = so::waitForFlagToChange;
        Runnable r3 = so::waitForFlagToChange;

        Thread t1 = new Thread(r1, "Thread A");
        Thread t2 = new Thread(r2, "Thread B");
        Thread t3 = new Thread(r3, "Thread C");



        Thread t4 = new Thread(so::changeStateAndNotifyAll, "Thread D");

        t1.start();
        t2.start();
        t3.start();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        t4.start();


    }
}
