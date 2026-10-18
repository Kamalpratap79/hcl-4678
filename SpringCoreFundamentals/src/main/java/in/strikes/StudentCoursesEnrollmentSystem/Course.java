package in.strikes.StudentCoursesEnrollmentSystem;

import org.springframework.stereotype.Component;

@Component
public class Course {

    private int courseId;
    private String courseName;
    private int durationMonths;

    public Course(int courseId, String courseName, int durationMonths) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.durationMonths = durationMonths;
    }

    public int getCourseId() {
        return courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public int getDurationMonths() {
        return durationMonths;
    }

    public void display(){
        System.out.println("CourseId is : "+ courseId);
        System.out.println("CourseName is : " + courseName);
        System.out.println("duration : " + durationMonths + " Months");
    }
}
