package fooddelivery.domain;

import fooddelivery.FrontApplication;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Transaction_table")
@Data
public class Transaction {

    @Id
    //@GeneratedValue(strategy=GenerationType.AUTO)

    private String transactionId;

    private String orderId;

    private String transactionStatus;

    @PrePersist
    public void onPrePersist() {}

    public static TransactionRepository repository() {
        TransactionRepository transactionRepository = FrontApplication.applicationContext.getBean(
            TransactionRepository.class
        );
        return transactionRepository;
    }

    public void completeTransaction() {
        //implement business logic here:

        TransactionCompleted transactionCompleted = new TransactionCompleted(
            this
        );
        transactionCompleted.publishAfterCommit();
    }
}
