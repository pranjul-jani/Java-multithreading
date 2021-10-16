interface interface1 {
    public void call();
}

interface interface2 {
    public void call();
}



public class MultipleInheritanceExample implements interface2, interface1 {

    @Override
    public void call() {
        System.out.println("child class implementation");
    }

    public static void main(String[] args) {
        MultipleInheritanceExample ob = new MultipleInheritanceExample();

        ob.call();
    }
}
