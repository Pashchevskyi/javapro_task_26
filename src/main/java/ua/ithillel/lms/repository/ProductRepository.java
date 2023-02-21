package ua.ithillel.lms.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ua.ithillel.lms.model.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {

}
