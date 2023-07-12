package fooddelivery.domain;

import fooddelivery.StoreApplication;
import fooddelivery.domain.OrderReceived;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Store_table")
@Data
public class Store {

    @Id
    //@GeneratedValue(strategy=GenerationType.AUTO)

    private String storeId;

    private String storeName;

    private String ownerId;

    private String storeStatus;

    @PostPersist
    public void onPostPersist() {
        OrderReceived orderReceived = new OrderReceived(this);
        orderReceived.publishAfterCommit();
    }

    @PrePersist
    public void onPrePersist() {}

    public static StoreRepository repository() {
        StoreRepository storeRepository = StoreApplication.applicationContext.getBean(
            StoreRepository.class
        );
        return storeRepository;
    }

    public void acceptOrder() {
        //implement business logic here:

        OrderAccepted orderAccepted = new OrderAccepted(this);
        orderAccepted.publishAfterCommit();
    }

    public void rejectOrder() {
        //implement business logic here:

        OrderRejected orderRejected = new OrderRejected(this);
        orderRejected.publishAfterCommit();
    }

    public void startCooking() {
        //implement business logic here:

        CookingStart cookingStart = new CookingStart(this);
        cookingStart.publishAfterCommit();
    }

    public void completeCooking() {
        //implement business logic here:

        CookingComplete cookingComplete = new CookingComplete(this);
        cookingComplete.publishAfterCommit();
    }
}
