package ua.ithillel.lms.configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ua.ithillel.lms.model.Order;
import ua.ithillel.lms.model.OrderList;
import ua.ithillel.lms.model.Product;

@Configuration
@EnableConfigurationProperties
@ConfigurationProperties
@Getter
@Setter
public class AppConfiguration {

  private String name;
  private String environment;
  private boolean enabled;
  private List<String> servers = new ArrayList<>();

  @Bean
  ObjectMapper objectMapper() {
    return new ObjectMapper();
  }
}
