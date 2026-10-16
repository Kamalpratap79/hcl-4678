package Day6.Streams;


import java.util.ArrayList;

public class StreamTask {
    static class Members {
        String name;
        String gender;

        public Members(String name, String gender) {
            this.name = name;
            this.gender = gender;
        }
    }
        public static void main(String[] args) {
            ArrayList<Members> Li = new ArrayList<>();
            Li.add(new Members("prateek","male"));
            Li.add(new Members("mradul","male"));
            Li.add(new Members("manshi","female"));
            Li.add(new Members("parul","female"));
            Li.add(new Members("divy","male"));

            Li.stream().map(a->{
                if(a.gender == "male") return "mr."+a.name;
                return "miss."+a.name;
            }).forEach(System.out::println);
        }

}
