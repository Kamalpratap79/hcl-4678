package in.strikes.Day9.notificationService;

import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Primary
@Scope("prototype")
public class EmailService implements NotificationService {

    @Override
    public void sendMsg(String msg) {
        System.out.println("Email service :"+msg);
    }
}
