package Day8;

public class Student {

    //rule1 : make constructor private
    private Student(){
        System.out.println("Inside the private constructor");
    }

    static final Student s2 = new Student();
    public static Student getInstance(){
        return s2;
    }

    public String getMsg(){
        return "hi i am msg";
    }

    private String name;
    private int Rollno;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRollno() {
        return Rollno;
    }

    public void setRollno(int rollno) {
        Rollno = rollno;
    }

}
