import com.sun.org.apache.xpath.internal.operations.Mult;

class Multi1 extends Thread {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " has priority " + Thread.currentThread().getPriority() + " -> is running");
    }
}

class A extends Thread{
    public void run(){
        System.out.println("Class A method...");
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
        }
    }
}
class B extends Thread{
    public void run(){
        System.out.println("Class B method...");
        for (int i = 10; i > 0; i--) {
            System.out.println(i);
        }
    }
}

class Table{
    synchronized void printTable(int n){//synchronized method
        for(int i=1;i<=5;i++){
            System.out.println(n*i);
            try{
                Thread.sleep(400);
            }catch(Exception e){
                System.out.println(e);
            }
        }

    }
}

class MyThread1 extends Thread{
    Table t;
    MyThread1(Table t){
        this.t=t;
    }
    public void run(){
        t.printTable(5);
    }

}
class MyThread2 extends Thread{
    Table t;
    MyThread2(Table t){
        this.t=t;
    }
    public void run(){
        t.printTable(100);
    }
}


public class ThreadExampleOne extends Thread{
    public static void main(String[] args) {
        Multi1 t = new Multi1();
        t.start();

        A a = new A();
        B b = new B();

        a.setPriority(Thread.MAX_PRIORITY);
        b.setPriority(Thread.MIN_PRIORITY);

        b.start();
        a.start();

        Table obj = new Table();//only one object
        MyThread1 t1=new MyThread1(obj);
        MyThread2 t2=new MyThread2(obj);

        System.out.println("---------------------end of a and b---------------------------");

        t1.start();
        t2.start();
    }
}
