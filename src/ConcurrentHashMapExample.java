import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapExample extends Thread {

    static ConcurrentHashMap<Integer, Character> m = new ConcurrentHashMap<>();

    public void run() {
        try {
            Thread.sleep(1000);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("child thread updating map");
        m.replace(101,'A','a');
        m.put(103,'C');
    }

    public static void main(String[] args) throws InterruptedException {
        m.put(101,'A');
        m.put(102,'B');

        ConcurrentHashMapExample t = new ConcurrentHashMapExample();

        t.start();

        Set<Integer> s1 = m.keySet();
        Iterator<Integer> itr = s1.iterator();

        // there is no guarantee that entry added by child thread is available to the iterator
        while(itr.hasNext()) {
            Integer I1  = (Integer) itr.next();

            System.out.println("main thread iterating map and current entry is : " + I1 + "->" + m.get(I1));
            Thread.sleep(3000);
        }
        System.out.println(m);



    }

}
