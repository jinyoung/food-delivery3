package fooddelivery.domain;

import fooddelivery.domain.*;
import fooddelivery.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class CookingStart extends AbstractEvent {

    public CookingStart(Store aggregate) {
        super(aggregate);
    }

    public CookingStart() {
        super();
    }
}
