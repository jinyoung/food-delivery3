package fooddelivery.domain;

import fooddelivery.domain.*;
import fooddelivery.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class NotificationSent extends AbstractEvent {

    public NotificationSent(Notification aggregate) {
        super(aggregate);
    }

    public NotificationSent() {
        super();
    }
}
