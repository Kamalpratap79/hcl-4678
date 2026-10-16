package Day4;

import java.util.Iterator;
import java.util.Stack;

public class col3 {
    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        st.push(5);
        st.push(3);
        st.push(8);
        st.push(6);
        System.out.println(st);
        st.pop();
        System.out.println(st);

        Iterator<Integer> it = st.iterator();
        while(it.hasNext()){
            Integer a = it.next();
            System.out.println(a);
        }
    }
}

