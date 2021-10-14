import java.util.Date;

public class ImmutableClassExample {

    private final Date dob;
    private final int[] arr;

    ImmutableClassExample(Date dob, int[] arr) {
        this.dob = dob;
        this.arr = arr;
    }

    public Date getDob() {
        return (Date) dob.clone();
    }

    public int[] getArr() {
        return arr.clone();
    }

    public void print(int[] arr) {
        for (int i=0;i<arr.length;i++) {
            System.out.println(arr[i]);
        }
    }

    public static void main(String[] args) {
        ImmutableClassExample ob = new ImmutableClassExample(new Date(), new int[]{1,2,3});
        System.out.println(ob.dob);
        int[] arr = ob.getArr();
        ob.print(arr);
        ob.getDob().setYear(2022);
        ob.arr[0] = 4;
        System.out.println(ob.dob);
        ob.print(ob.getArr());

    }
}
