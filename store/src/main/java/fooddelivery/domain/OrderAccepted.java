package fooddelivery.domain;

import fooddelivery.domain.*;
import fooddelivery.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class OrderAccepted extends AbstractEvent {

    public OrderAccepted(Store aggregate) {
        super(aggregate);
    }

    public OrderAccepted() {
        super();
    }
}
