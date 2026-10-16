package Day6.Streams;

import Pack1.A;

import java.util.ArrayList;
import java.util.stream.Stream;

public class stream {
    public static void main(String[] args) {
        ArrayList<Integer> Ls = new ArrayList<>();
        ArrayList<String> st = new ArrayList<>();

        Ls.add(1);
        Ls.add(3);
        Ls.add(6);
        Ls.add(8);

        Stream<Integer> ans = Ls.stream().filter(a->a%2 == 0);
        System.out.println(ans.toList());

        st.add("modi");
        st.add("akhilesh");
        st.add("babaji");
        st.add("brijBhusan");
        st.add("rahulGandhi");
        st.add("laalu");

        st.stream().forEach(System.out::println);
        Stream<String> res = st.stream().filter(a->a.startsWith("b"));
        System.out.println(res.toList());

    }
}
