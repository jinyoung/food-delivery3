package fooddelivery.domain;

import fooddelivery.domain.*;
import fooddelivery.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class TransactionCompleted extends AbstractEvent {

    public TransactionCompleted(Transaction aggregate) {
        super(aggregate);
    }

    public TransactionCompleted() {
        super();
    }
}
