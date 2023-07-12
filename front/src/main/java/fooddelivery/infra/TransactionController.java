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
// @RequestMapping(value="/transactions")
@Transactional
public class TransactionController {

    @Autowired
    TransactionRepository transactionRepository;

    @RequestMapping(
        value = "transactions/{id}/",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8"
    )
    public Transaction completeTransaction(
        @PathVariable(value = "id") String id,
        HttpServletRequest request,
        HttpServletResponse response
    ) throws Exception {
        System.out.println(
            "##### /transaction/completeTransaction  called #####"
        );
        Optional<Transaction> optionalTransaction = transactionRepository.findById(
            id
        );

        optionalTransaction.orElseThrow(() -> new Exception("No Entity Found"));
        Transaction transaction = optionalTransaction.get();
        transaction.completeTransaction();

        transactionRepository.save(transaction);
        return transaction;
    }
}
