package pictosearcher.springapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pictosearcher.springapp.api.client.SearchPictoClient;
import reactor.core.publisher.Mono;

/**
 * This controller is responsible for fetching Picto information.
 * <p>
 * It makes use of the SearchPictoClient to call an external API for fetching the required data.
 * </p>
 */
@RestController
public class FetchPictoController {
  private final SearchPictoClient searchPictoClientClient;

  /**
   * Constructs a new FetchPictoController with the given SearchPictoClient.
   *
   * @param searchPictoClientClient the client used for searching pictogram
   */
  @Autowired
  public FetchPictoController(SearchPictoClient searchPictoClientClient) {
    this.searchPictoClientClient = searchPictoClientClient;
  }

  /**
   * Fetches the Picto data based on the given text query parameter.
   * <p>
   * This method uses the SearchPictoClient to call an external API and fetch the Picto data. It
   * then transforms the data to return only the Picto ID.
   * </p>
   *
   * @param text the text query used for searching pictogram
   * @return a Mono containing the Picto ID, or an empty Mono if not found
   */
  // If you use a different port from the frontend, set CrossOrigin.
  // @CrossOrigin(origins = "http://localhost:3000")
  @GetMapping("/fetch")
  public Mono<Integer[]> fetchData(@RequestParam("text") String text) {
    return searchPictoClientClient.callApi(text).map(dto -> dto.getPictoId());
  }

  // @GetMapping("/fetch/{query}")
  // public Mono<Integer> fetchData(@PathVariable String query) {
  // return searchPictoClientClient.callApi(query).map(dto -> dto.getPictoId());
  // }
}
