class ParentClass {

    public void property() {
        System.out.println("We live in India");
    }

    public Object career() {
        System.out.println("Parents wants to be Doctor");
        return null;
    }

    public Number cash() {
        System.out.println("$1000 given by parents");
        return null;
    }

}


public class InheritanceExample extends ParentClass{

    @Override
    public String career() {
        System.out.println("Child wants to be Software Engineer");
        return null;
    }

    @Override
    public Integer cash() {
        super.cash();
        System.out.println("$15000 earned by child");
        return null;
    }

    public static void main(String[] args) {
        InheritanceExample ob = new InheritanceExample();
        ParentClass p = new InheritanceExample();


        p.career();

        ob.property();
        ob.career();
        ob.cash();

        int a = 10;
    }
}
