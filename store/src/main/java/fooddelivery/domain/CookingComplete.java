package fooddelivery.domain;

import fooddelivery.domain.*;
import fooddelivery.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class CookingComplete extends AbstractEvent {

    public CookingComplete(Store aggregate) {
        super(aggregate);
    }

    public CookingComplete() {
        super();
    }
}
