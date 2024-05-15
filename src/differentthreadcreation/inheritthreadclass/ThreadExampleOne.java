package differentthreadcreation.inheritthreadclass;

public class ThreadExampleOne {
    public static class MyThread extends Thread {
        @Override
        public void run() {
            System.out.println("My thread running");
            System.out.println("My thread finished");
        }
    }

    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start();
    }

}
