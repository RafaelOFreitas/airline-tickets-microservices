package br.com.airline.voocommand.adapter.in.web.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ErrorType {
  INVALID_DATA("Invalid Data"),
  SYSTEM_ERROR("System Error"),
  INVALID_PARAMETER("Invalid Parameter"),
  INCOMPREHENSIBLE_MESSAGE("Incomprehensible Message"),
  BUSINESS_ERROR("Business Rule Violation");

  private final String title;
}
