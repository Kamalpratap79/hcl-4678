package in.strikes.StudentCoursesEnrollmentSystem;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class MainApp {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        StudentService service = context.getBean(StudentService.class);
        Student student = context.getBean(Student.class);
        service.displayStudentProfile(student);
    }
}
