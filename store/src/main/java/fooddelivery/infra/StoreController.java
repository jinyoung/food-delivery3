package fooddelivery.infra;

import fooddelivery.domain.*;
import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
// @RequestMapping(value="/stores")
@Transactional
public class StoreController {

    @Autowired
    StoreRepository storeRepository;

    @RequestMapping(
        value = "stores/{id}/",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8"
    )
    public Store acceptOrder(
        @PathVariable(value = "id") String id,
        HttpServletRequest request,
        HttpServletResponse response
    ) throws Exception {
        System.out.println("##### /store/acceptOrder  called #####");
        Optional<Store> optionalStore = storeRepository.findById(id);

        optionalStore.orElseThrow(() -> new Exception("No Entity Found"));
        Store store = optionalStore.get();
        store.acceptOrder();

        storeRepository.save(store);
        return store;
    }

    @RequestMapping(
        value = "stores/{id}/",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8"
    )
    public Store rejectOrder(
        @PathVariable(value = "id") String id,
        HttpServletRequest request,
        HttpServletResponse response
    ) throws Exception {
        System.out.println("##### /store/rejectOrder  called #####");
        Optional<Store> optionalStore = storeRepository.findById(id);

        optionalStore.orElseThrow(() -> new Exception("No Entity Found"));
        Store store = optionalStore.get();
        store.rejectOrder();

        storeRepository.save(store);
        return store;
    }

    @RequestMapping(
        value = "stores/{id}/",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8"
    )
    public Store startCooking(
        @PathVariable(value = "id") String id,
        HttpServletRequest request,
        HttpServletResponse response
    ) throws Exception {
        System.out.println("##### /store/startCooking  called #####");
        Optional<Store> optionalStore = storeRepository.findById(id);

        optionalStore.orElseThrow(() -> new Exception("No Entity Found"));
        Store store = optionalStore.get();
        store.startCooking();

        storeRepository.save(store);
        return store;
    }

    @RequestMapping(
        value = "stores/{id}/",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8"
    )
    public Store completeCooking(
        @PathVariable(value = "id") String id,
        HttpServletRequest request,
        HttpServletResponse response
    ) throws Exception {
        System.out.println("##### /store/completeCooking  called #####");
        Optional<Store> optionalStore = storeRepository.findById(id);

        optionalStore.orElseThrow(() -> new Exception("No Entity Found"));
        Store store = optionalStore.get();
        store.completeCooking();

        storeRepository.save(store);
        return store;
    }
}
