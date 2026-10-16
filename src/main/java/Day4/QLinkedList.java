package Day4;

import java.util.*;

public class QLinkedList {
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(1);
        q.offer(2);
        q.offer(7);
        q.offer(5);
        System.out.println(q);
        System.out.println(q.poll());

        Queue<Integer> d = new ArrayDeque<>();
        d.offer(23);
        d.offer(98);
        d.offer(56);
        d.offer(88);
        System.out.println(d);
        System.out.println(d.peek());
        d.poll();
        System.out.println(d);

        System.out.println("Implementing stack");
        ArrayDeque<Integer> st = new ArrayDeque<>();
        st.push(2);
        st.push(3);
        st.push(5);
        System.out.println(st);
        st.pop();
        System.out.println(st);





    }
}
