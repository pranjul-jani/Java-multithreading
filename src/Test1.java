public class Test1 {
    static {
        System.out.println("b");
    }

    public static void main(String[] args) {
        System.out.println("c");
        System.out.println(Test.i);
        Test.m1();
    }
}
