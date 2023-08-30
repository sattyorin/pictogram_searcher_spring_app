package pictosearcher.springapp.api.client;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import pictosearcher.springapp.api.dto.SearchPictoRequestDto;
import pictosearcher.springapp.api.dto.SearchPictoResponseDto;
import reactor.core.publisher.Mono;

/**
 * Client for interacting with the pictogram search API.
 * <p>
 * This component is responsible for making API calls to an external service for searching
 * pictogram. It utilizes the WebClient for making the HTTP requests.
 * </p>
 */
@Component
public class SearchPictoClient {

  private final WebClient webClient;

  public SearchPictoClient(WebClient webClient) {
    this.webClient = webClient;
  }

  /**
   * Calls the pictogram search API with the provided query.
   * <p>
   * This method makes a POST request to the "/search" endpoint of the pictogram search API. It
   * sends the query in the request body and expects a response that it converts to a
   * SearchPictoResponseDto.
   * </p>
   *
   * @param query the search query
   * @return a Mono containing the API response mapped to a SearchPictoResponseDto
   */
  public Mono<SearchPictoResponseDto> callApi(String query) {
    return webClient.post().uri("/search").bodyValue(new SearchPictoRequestDto(query)).retrieve()
        .bodyToMono(SearchPictoResponseDto.class);
  }
}

