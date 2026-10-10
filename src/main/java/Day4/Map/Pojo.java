package Day4.Map;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

class Student {
    String name;
    int rollno;
    int age;
    int marks;

    Student(String name,int rollno,int age,int marks){
        this.name = name;
        this.rollno = rollno;
        this.age = age;
        this.marks = marks;
    }
    @Override
    public String toString() {
        return "Student{name='" + name + "', rollno=" + rollno + ", age=" + age + ", marks=" + marks + "}";
    }

//    public int compareTo(Student )

}
public class Pojo {
    public static void main(String[] args) {
        List<Student> ls = new ArrayList<>(10);
        ls.add(new Student("mradul",1,21,50));
        ls.add(new Student("prateek",2,20,40));
        ls.add(new Student("rohan",3,23,78));
        ls.add(new Student("harry",4,21,90));
        ls.add(new Student("mradl",5,24,60));
        ls.add(new Student("radul",6,22,50));
        ls.add(new Student("adul",7,27,30));
        ls.add(new Student("dul",8,19,70));
        ls.add(new Student("mra",9,25,80));
        ls.add(new Student("divy",10,21,50));

        System.out.println(ls);
        Collections.sort(ls, (s1, s2) -> Integer.compare(s1.age, s2.age));
        System.out.println(ls);
    }


}
