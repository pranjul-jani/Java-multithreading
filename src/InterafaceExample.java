interface interf {

    public void m1();
    public void m2();

}

public abstract class InterafaceExample implements interf {


    @Override
    public void m1() {

    }
}

class SubInterafaceExample extends InterafaceExample {
    @Override
    public void m2() {

    }

}
