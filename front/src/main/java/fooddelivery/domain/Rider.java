package fooddelivery.domain;

import fooddelivery.FrontApplication;
import fooddelivery.domain.DeliveryOrderViewed;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Rider_table")
@Data
public class Rider {

    @Id
    //@GeneratedValue(strategy=GenerationType.AUTO)

    private String riderId;

    private String name;

    private String phoneNumber;

    private Location location;

    @PostPersist
    public void onPostPersist() {
        DeliveryOrderViewed deliveryOrderViewed = new DeliveryOrderViewed(this);
        deliveryOrderViewed.publishAfterCommit();
    }

    public static RiderRepository repository() {
        RiderRepository riderRepository = FrontApplication.applicationContext.getBean(
            RiderRepository.class
        );
        return riderRepository;
    }
}
