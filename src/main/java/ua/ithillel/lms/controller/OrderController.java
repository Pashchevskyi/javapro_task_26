package ua.ithillel.lms.controller;

import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.ithillel.lms.dto.OrderDto;
import ua.ithillel.lms.exception.OrderNotFoundException;
import ua.ithillel.lms.service.OrderService;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
@Slf4j
public class OrderController {

  private final OrderService orderService;

  @GetMapping("/")
  public List<OrderDto> getOrders() {
    return orderService.getOrders();
  }

  @GetMapping("/{id}")
  public OrderDto getOrderById(@PathVariable long id) {
    OrderDto orderDto = new OrderDto();
    try {
      orderDto = orderService.getOrderById(id);
    } catch (OrderNotFoundException e) {
      log.error(e.getMessage());
    }
    return orderDto;
  }

  @PostMapping("/")
  public OrderDto addOrder(@RequestBody OrderDto orderDto) {
    return orderService.addOrder(orderDto);
  }

  @DeleteMapping("/{id}")
  public List<OrderDto> deleteOrder(@PathVariable long id) {
    List<OrderDto> orderDtoList = new ArrayList<>();
    try {
      orderDtoList = orderService.deleteOrder(id);
    } catch (OrderNotFoundException e) {
      log.error(e.getMessage());
    }
    return orderDtoList;
  }
}
