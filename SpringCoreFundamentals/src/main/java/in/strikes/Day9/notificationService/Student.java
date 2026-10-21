package in.strikes.Day9.notificationService;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component
public class Student {

    private NotificationService notificationService;

    public Student(NotificationService notificationService){
        this.notificationService = notificationService;
    }

    public String notifyStudent(){
        notificationService.sendMsg("Your assement is scheduled");
        return null;
    }

    @PostConstruct
    public void init(){
        System.out.println("Object created");
    }

    @PreDestroy
    public void destroy(){
        System.out.println("Object destroyed");
    }
}
