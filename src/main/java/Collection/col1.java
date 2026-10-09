package Collection;

import java.util.ArrayList;

public class col1 {
    public static void main(String[] args) {
        ArrayList<Integer> ar = new ArrayList<>();
        ar.add(5);
        ar.add(6);
        ar.add(5);
        ar.add(2);
        System.out.println(ar);
        ar.set(3,7);
        System.out.println(ar);
    }
}
