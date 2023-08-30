package pictosearcher.springapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

/**
 * Entry point for the Spring Boot application.
 * <p>
 * This class contains the main method to run the Spring Boot application. It also defines Beans
 * that are used across the application.
 * </p>
 */
@SpringBootApplication
public class SpringappApplication {

  /**
   * The main method that starts the Spring Boot application.
   *
   * @param args Command line arguments
   */
  public static void main(String[] args) {
    SpringApplication.run(SpringappApplication.class, args);
  }

  /**
   * Provides a WebClient.Builder bean for making HTTP requests.
   * <p>
   * This bean is used for configuring WebClient instances throughout the application.
   * </p>
   *
   * @return a WebClient.Builder bean
   */
  @Bean
  public WebClient.Builder getWebClientBuilder() {
    return WebClient.builder();
  }
}
