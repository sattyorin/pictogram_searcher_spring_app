package pictosearcher.springapp.api.dto;

import lombok.Data;
import lombok.Getter;

/**
 * This is SearchPictoResponseDto.
 */
@Data
@Getter
public class SearchPictoResponseDto {
  private String success;
  private String message;
  private Integer[] pictoId;
}
