package in.strikes.StudentCoursesEnrollmentSystem;

public class Student {

    private int StudentId;
    private String name;
    private Course course;

    public Student(int studentId, String name,Course course) {
        StudentId = studentId;
        this.name = name;
        this.course = course;
    }

    public void display(){
        System.out.println("StudentId is : "+ StudentId);
        System.out.println("name is : "+ name);
        course.display();
    }



}
