package in.strikes.StudentCoursesEnrollmentSystem;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class AppConfig {

    @Bean
    public Course course(){
        return new Course(101,"SpringFramework",6);
    }

    @Bean
    public Student student(Course course){
        return new Student(1,"pranav",course);
    }

    @Bean
    public StudentService studentService(Student student){
        return new StudentService(student);
    }


}
