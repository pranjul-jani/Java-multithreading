public class SingletonPatternExample {

    //https://www.youtube.com/watch?v=Z5TRputhzHs&t=1s

    // volatile keyword here makes sure that the changes made in one thread are
    // immediately reflect in other thread
    static private volatile SingletonPatternExample instance;

    // we made the constructor private therefore no one will be able to access it
    private SingletonPatternExample() {
    }

    // this is not thread safe if 2 threads t1 and t2 tries to access the resource at the same time
    // then 2 instance will be created therefore nor thread safe
    // easy option is to create a synchronized block but not efficient
    /*

    Double check locking

    public static SingletonPatternExample getInstance() {
        if(instance == null) {
            synchronized(this) {
                if(instance == null) {
                instance = new SingletonPatternExample();
                }
            }
        }
        return instance;
    }
    */
    public static SingletonPatternExample getInstance() {
        if(instance == null) {
            instance = new SingletonPatternExample();
        }
        return instance;
    }

    public static void main(String[] args) {

        SingletonPatternExample a = SingletonPatternExample.getInstance();
        SingletonPatternExample b = SingletonPatternExample.getInstance();

        System.out.println(a.hashCode() == b.hashCode());

    }
}
