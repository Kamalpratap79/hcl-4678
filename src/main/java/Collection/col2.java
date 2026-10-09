package Collection;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

public class col2 {
    public static void main(String[] args) {
        LinkedList<Integer> ar = new LinkedList<>();
        ar.add(5);
        ar.add(6);
        ar.add(5);
        ar.add(2);
        System.out.println(ar);
        ar.set(3,7);
        System.out.println(ar);

    }
}

