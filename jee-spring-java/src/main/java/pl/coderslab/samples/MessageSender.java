package pl.coderslab.samples;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class MessageSender {

    private NotificationService notificationService;

    @Autowired
    public MessageSender(@Qualifier("email") NotificationService notificationService) {
        this.notificationService = notificationService;
    }

}
/*

public class ShowNotification {

private NotificationService notificationService;

public ShowNotification(@Qualifier("post") NotificationService notSer){
    this.notificationService = notSer;
}

}





 */