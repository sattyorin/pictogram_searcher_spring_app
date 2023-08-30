package pictosearcher.springapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

/**
 * Configuration class for WebClient.
 */
@Configuration
public class WebClientConfig {

  /**
   * Provides a WebClient bean.
   *
   * @return a configured WebClient instance
   */
  @Bean
  public WebClient webClient() {
    return WebClient.create("http://localhost:5000");
  }
}
