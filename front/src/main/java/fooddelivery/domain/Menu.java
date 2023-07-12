package fooddelivery.domain;

import fooddelivery.FrontApplication;
import fooddelivery.domain.MenuSelected;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Menu_table")
@Data
public class Menu {

    @Id
    //@GeneratedValue(strategy=GenerationType.AUTO)

    private String menuId;

    private String menuName;

    private Money price;

    private String description;

    private List<String> options;

    @PostPersist
    public void onPostPersist() {
        MenuSelected menuSelected = new MenuSelected(this);
        menuSelected.publishAfterCommit();
    }

    public static MenuRepository repository() {
        MenuRepository menuRepository = FrontApplication.applicationContext.getBean(
            MenuRepository.class
        );
        return menuRepository;
    }
}
