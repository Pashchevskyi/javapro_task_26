package ua.ithillel.lms;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.event.EventListener;
import ua.ithillel.lms.configuration.AppConfiguration;
import ua.ithillel.lms.controller.DefaultController;

/**
 * Hello world!
 */
@Slf4j
@SpringBootApplication
public class App extends SpringBootServletInitializer {

  @Autowired
  private AppConfiguration myConfig;

  public static void main(String[] args) {
    SpringApplication sa = new SpringApplication(App.class);
    sa.run(args);
  }

  @EventListener(ApplicationReadyEvent.class)
  public void onInit() {
    log.info("using environment: {}", myConfig.getEnvironment());
    log.info("name: {}", myConfig.getName());
    log.info("enabled:{}", myConfig.isEnabled());
    log.info("servers: {}", myConfig.getServers());
  }

  @Override
  protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
    return builder.sources(DefaultController.class);
  }
}
