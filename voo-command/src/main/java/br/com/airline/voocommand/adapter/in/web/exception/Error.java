package br.com.airline.voocommand.adapter.in.web.exception;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.time.OffsetDateTime;
import java.util.List;
import lombok.Builder;
import lombok.Getter;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Builder
public class Error {

  private final Integer status;
  private final OffsetDateTime timestamp;
  private final String type;
  private final String title;
  private final String detail;
  private final String userMessage;
  private final List<Field> fields;

  @Getter
  @Builder
  public static class Field {

    private final String name;
    private final String userMessage;
  }
}
