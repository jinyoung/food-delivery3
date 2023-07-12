package fooddelivery.domain;

import fooddelivery.StoreApplication;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Owner_table")
@Data
public class Owner {

    @Id
    //@GeneratedValue(strategy=GenerationType.AUTO)

    private String ownerId;

    private String ownerName;

    private String phoneNumber;

    public static OwnerRepository repository() {
        OwnerRepository ownerRepository = StoreApplication.applicationContext.getBean(
            OwnerRepository.class
        );
        return ownerRepository;
    }
}
