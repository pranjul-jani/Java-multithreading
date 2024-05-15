package differentthreadcreation.implementrunnableinterface;

public class ThreadExampleTwo {

    public static class MyRunnable implements Runnable {

        @Override
        public void run() {
            System.out.println("My Runnable running");
            System.out.println("My Runnable finished");
        }
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new MyRunnable());
        thread.start();
    }
}
