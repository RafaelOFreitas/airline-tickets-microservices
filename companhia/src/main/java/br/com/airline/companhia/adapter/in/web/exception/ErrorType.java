package br.com.airline.companhia.adapter.in.web.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ErrorType {
  INVALID_DATA("Invalid Data"),
  SYSTEM_ERROR("System Error"),
  INVALID_PARAMETER( "Invalid Parameter"),
  INCOMPREHENSIBLE_MESSAGE( "Incomprehensible Message"),
  RESOURCE_NOT_FOUND( "Resource Not Found"),
  ENTITY_IN_US( "Entity in Use"),
  BUSINESS_ERROR( "Business Rule Violation");

  private final String title;
}
