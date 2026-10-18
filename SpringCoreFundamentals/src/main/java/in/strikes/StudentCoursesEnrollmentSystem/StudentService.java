package in.strikes.StudentCoursesEnrollmentSystem;

import org.springframework.stereotype.Component;

@Component
public class StudentService {
    private final Student student;

    public StudentService(Student student){
        this.student = student;
    }


    public void displayStudentProfile(Student student){
        student.display();
    }
}

