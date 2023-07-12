package fooddelivery.domain;

import fooddelivery.domain.*;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(
    collectionResourceRel = "transactions",
    path = "transactions"
)
public interface TransactionRepository
    extends PagingAndSortingRepository<Transaction, String> {}
