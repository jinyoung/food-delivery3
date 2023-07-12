package fooddelivery.domain;

import fooddelivery.FrontApplication;
import fooddelivery.domain.OrderAccepted;
import fooddelivery.domain.OrderCancelled;
import fooddelivery.domain.OrderPlaced;
import fooddelivery.domain.OrderRejected;
import fooddelivery.domain.OrderStatusChecked;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Order_table")
@Data
public class Order {

    @Id
    //@GeneratedValue(strategy=GenerationType.AUTO)

    private String orderId;

    private String customerId;

    private String menuId;

    private String orderStatus;

    private String deliveryStatus;

    @PostPersist
    public void onPostPersist() {
        OrderPlaced orderPlaced = new OrderPlaced(this);
        orderPlaced.publishAfterCommit();

        OrderAccepted orderAccepted = new OrderAccepted(this);
        orderAccepted.publishAfterCommit();

        OrderRejected orderRejected = new OrderRejected(this);
        orderRejected.publishAfterCommit();

        OrderCancelled orderCancelled = new OrderCancelled(this);
        orderCancelled.publishAfterCommit();

        OrderStatusChecked orderStatusChecked = new OrderStatusChecked(this);
        orderStatusChecked.publishAfterCommit();
    }

    @PrePersist
    public void onPrePersist() {}

    public static OrderRepository repository() {
        OrderRepository orderRepository = FrontApplication.applicationContext.getBean(
            OrderRepository.class
        );
        return orderRepository;
    }
}
