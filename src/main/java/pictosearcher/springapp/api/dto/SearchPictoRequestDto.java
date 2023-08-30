package pictosearcher.springapp.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

/**
 * This is SearchPictoRequestDto.
 */
@Data
@Getter
@AllArgsConstructor
public class SearchPictoRequestDto {
  private String query;
}
