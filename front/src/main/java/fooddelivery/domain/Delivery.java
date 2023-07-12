package fooddelivery.domain;

import fooddelivery.FrontApplication;
import fooddelivery.domain.DeliveryNotification;
import fooddelivery.domain.OrderReceived;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Delivery_table")
@Data
public class Delivery {

    @Id
    //@GeneratedValue(strategy=GenerationType.AUTO)

    private String deliveryId;

    private String orderId;

    private String riderId;

    private String deliveryStatus;

    private Location deliveryLocation;

    @PostPersist
    public void onPostPersist() {
        OrderReceived orderReceived = new OrderReceived(this);
        orderReceived.publishAfterCommit();

        DeliveryNotification deliveryNotification = new DeliveryNotification(
            this
        );
        deliveryNotification.publishAfterCommit();
    }

    @PrePersist
    public void onPrePersist() {}

    public static DeliveryRepository repository() {
        DeliveryRepository deliveryRepository = FrontApplication.applicationContext.getBean(
            DeliveryRepository.class
        );
        return deliveryRepository;
    }

    public void startDelivery() {
        //implement business logic here:

        DeliveryStarted deliveryStarted = new DeliveryStarted(this);
        deliveryStarted.publishAfterCommit();
    }

    public void completeDelivery() {
        //implement business logic here:

        DeliveryCompleted deliveryCompleted = new DeliveryCompleted(this);
        deliveryCompleted.publishAfterCommit();
    }
}
