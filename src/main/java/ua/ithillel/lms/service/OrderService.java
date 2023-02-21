package ua.ithillel.lms.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ua.ithillel.lms.dto.OrderDto;
import ua.ithillel.lms.exception.OrderNotFoundException;
import ua.ithillel.lms.model.Order;
import ua.ithillel.lms.repository.OrderRepository;

@Service
@RequiredArgsConstructor
public class OrderService {

  private final OrderRepository orderRepository;
  private final ObjectMapper objectMapper;

  /**
   * Returns OrderDto mapping of Order object by id of searching Order
   *
   * @param id of Order to search for
   * @return OrderDto object
   * @throws OrderNotFoundException if Order has not been found
   */
  public OrderDto getOrderById(long id) throws OrderNotFoundException {
    Order order = orderRepository.findById(id).orElseThrow(() -> new OrderNotFoundException(id));
    return objectMapper.convertValue(order, OrderDto.class);
  }

  /**
   * Returns list of OrderDto objects
   *
   * @return ArrayList<OrderDto>
   */
  public List<OrderDto> getOrders() {
    Iterable<Order> orders = orderRepository.findAll();
    List<OrderDto> result = new ArrayList<>();
    orders.forEach(order -> {
      result.add(objectMapper.convertValue(order, OrderDto.class));
    });
    return result;
  }

  /**
   * Returns OrderDto object for Order added
   *
   * @param orderDto object to add
   * @return OrderDto object added
   */
  public OrderDto addOrder(OrderDto orderDto) {
    Order order = objectMapper.convertValue(orderDto, Order.class);
    Order addedOrder = orderRepository.save(order);

    orderDto.setId(addedOrder.getId());
    return orderDto;
  }

  /**
   * Removes an Order object and returns OrderDto, mapped from the deleted one
   *
   * @param id of object, which you are going to delete
   * @return List of OrderDto mappings of Order objects without deleted object
   * @throws OrderNotFoundException if Order object has not been found
   */
  public List<OrderDto> deleteOrder(long id) throws OrderNotFoundException {
    orderRepository.deleteById(id);
    return getOrders();
  }
}
