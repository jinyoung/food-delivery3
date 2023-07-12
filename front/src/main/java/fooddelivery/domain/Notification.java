package fooddelivery.domain;

import fooddelivery.FrontApplication;
import fooddelivery.domain.NotificationSent;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Notification_table")
@Data
public class Notification {

    @Id
    //@GeneratedValue(strategy=GenerationType.AUTO)

    private String notificationId;

    private String message;

    @PostPersist
    public void onPostPersist() {
        NotificationSent notificationSent = new NotificationSent(this);
        notificationSent.publishAfterCommit();
    }

    public static NotificationRepository repository() {
        NotificationRepository notificationRepository = FrontApplication.applicationContext.getBean(
            NotificationRepository.class
        );
        return notificationRepository;
    }
}
