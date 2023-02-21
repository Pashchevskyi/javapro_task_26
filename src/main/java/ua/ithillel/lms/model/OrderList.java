package ua.ithillel.lms.model;

import java.util.List;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class OrderList {

  @Getter
  private final List<Order> orders;
}
