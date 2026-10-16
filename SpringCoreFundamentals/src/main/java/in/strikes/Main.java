package in.strikes;

import in.strikes.AppConfig;
import in.strikes.Employee;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;


public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        Employee emp = context.getBean(Employee.class);
        Employee emp2 = context.getBean(Employee.class);
        emp.display();
        System.out.println(emp.hashCode());
        System.out.println(emp2.hashCode());
    }
}