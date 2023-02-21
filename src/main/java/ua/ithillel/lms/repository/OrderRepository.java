package ua.ithillel.lms.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ua.ithillel.lms.model.Order;

@Repository
public interface OrderRepository extends CrudRepository<Order, Long> {

}
