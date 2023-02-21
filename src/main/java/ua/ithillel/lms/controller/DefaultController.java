package ua.ithillel.lms.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DefaultController {

  @GetMapping("/")
  public String hello() {
    return "It is recommended to use my first REST API Application in Java via Postman.\n"
        + "\n"
        + "If you use Postman, please, do the following.\n"
        + "\n"
        + "1. Create new collection, name it, for examole, \"hillel_javapro_rest_api\".\n"
        + "2. In this collection all request URLs will be http://localhost:8081 *\n"
        + "3. Create new GET request in Postman to URN \"orders/\" to get all orders list\n"
        + "   in JSON format.\n"
        + "4. Create new GET request in Postman to URN \"orders/{id}\" (for example\n"
        + "   \"orders/1\") to get order by id.\n"
        + "5. Create new POST request in Postman to URN \"orders/\" to add new order."
        + " * port for Tomcat application server may be changed via settings in "
        + "./src/main/resources/application.properties file (for example, server.port=8001 , if you"
        + " want to run the application on 8001 port)";
  }
}
