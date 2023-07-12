package fooddelivery.domain;

import fooddelivery.domain.*;
import fooddelivery.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class DeliveryOrderViewed extends AbstractEvent {

    public DeliveryOrderViewed(Rider aggregate) {
        super(aggregate);
    }

    public DeliveryOrderViewed() {
        super();
    }
}
