package fooddelivery.domain;

import fooddelivery.domain.*;
import fooddelivery.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class DeliveryNotification extends AbstractEvent {

    public DeliveryNotification(Delivery aggregate) {
        super(aggregate);
    }

    public DeliveryNotification() {
        super();
    }
}
