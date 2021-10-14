import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteListExample implements Runnable {

    static CopyOnWriteArrayList<String> l = new CopyOnWriteArrayList<>();

    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("child thread updating list");
        l.add("C");
    }

    public static void main(String[] args) throws InterruptedException {
        l.add("A");
        l.add("B");

        CopyOnWriteListExample ob = new CopyOnWriteListExample();
        Thread t = new Thread(ob);
        t.start();

        Iterator<String> itr = l.iterator();
        while (itr.hasNext()) {
            String s1 = itr.next();
            System.out.println("Main thread iterating list and current object is: " + s1);
            Thread.sleep(3000);
        }

        System.out.println(l);

    }
}
