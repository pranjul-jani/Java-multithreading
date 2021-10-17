class Example1 implements Runnable{

    @Override
    public void run(){
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
        }
    }
}


public class ThreadExampleTwo {

    public static void main(String[] args) {

        Example1 ex1 = new Example1();
        Thread t = new Thread(ex1);

        t.start();
    }
}
