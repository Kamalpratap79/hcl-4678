package in.strikes.Day9.notificationService;

import org.springframework.stereotype.Component;

@Component
public class WhatAppService implements NotificationService{

    @Override
    public void sendMsg(String msg) {
        System.out.println("WhatApp Service"+ msg);
    }
}
