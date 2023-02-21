package ua.ithillel.lms.exception;

public class OrderNotFoundException extends Exception {

  public OrderNotFoundException(long id) {
    super("Order with ID#" + id + " has not been found");
  }
}
