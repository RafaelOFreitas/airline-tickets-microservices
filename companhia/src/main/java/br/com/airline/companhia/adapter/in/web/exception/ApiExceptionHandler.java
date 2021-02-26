package br.com.airline.companhia.adapter.in.web.exception;

import br.com.airline.companhia.core.domain.exception.AeronaveNotFoundException;
import br.com.airline.companhia.core.domain.exception.CompanhiaNotFoundException;
import br.com.airline.companhia.core.domain.exception.RotaNotFoundException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import com.fasterxml.jackson.databind.exc.PropertyBindingException;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.lang.NonNullApi;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@AllArgsConstructor
@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

  private final MessageSource messageSource;
  public static final String GENERIC_ERROR_MESSAGE_END_USER = "An unexpected internal system error has occurred.";

  @ExceptionHandler(Exception.class)
  public ResponseEntity<Object> handleUncaught(Exception ex, WebRequest request) {
    var status = HttpStatus.INTERNAL_SERVER_ERROR;
    var errorType = ErrorType.SYSTEM_ERROR;

    ex.printStackTrace();

    Error error = this.createErrorBuilder(status, errorType, GENERIC_ERROR_MESSAGE_END_USER)
        .userMessage(GENERIC_ERROR_MESSAGE_END_USER)
        .build();

    return this.handleExceptionInternal(ex, error, new HttpHeaders(), status, request);
  }

  @ExceptionHandler(AeronaveNotFoundException.class)
  public ResponseEntity<Object> handleCredentialNotFoundException(
      AeronaveNotFoundException ex,
      WebRequest request
  ) {
    return this.getExceptionNotFound(ex, request);
  }

  @ExceptionHandler(CompanhiaNotFoundException.class)
  public ResponseEntity<Object> handleCredentialNotFoundException(
      CompanhiaNotFoundException ex,
      WebRequest request
  ) {
    return this.getExceptionNotFound(ex, request);
  }

  @ExceptionHandler(RotaNotFoundException.class)
  public ResponseEntity<Object> handleBusinessException(RotaNotFoundException ex, WebRequest request) {
    return this.getExceptionNotFound(ex, request);
  }

  @Override
  protected ResponseEntity<Object> handleBindException(
      BindException ex,
      HttpHeaders headers,
      HttpStatus status,
      WebRequest request
  ) {
    return handleValidationInternal(ex, headers, status, request, ex.getBindingResult());
  }

  @Override
  protected ResponseEntity<Object> handleMethodArgumentNotValid(
      MethodArgumentNotValidException ex,
      HttpHeaders headers,
      HttpStatus status,
      WebRequest request
  ) {
    return handleValidationInternal(ex, headers, status, request, ex.getBindingResult());
  }

  @Override
  protected ResponseEntity<Object> handleExceptionInternal(
      Exception ex,
      Object body,
      HttpHeaders headers,
      HttpStatus status,
      WebRequest request
  ) {
    if (body == null) {
      body = Error.builder()
          .timestamp(OffsetDateTime.now())
          .title(status.getReasonPhrase())
          .status(status.value())
          .userMessage(GENERIC_ERROR_MESSAGE_END_USER)
          .build();

      return super.handleExceptionInternal(ex, body, headers, status, request);
    }

    if (body instanceof String) {
      body = Error.builder()
          .timestamp(OffsetDateTime.now())
          .title((String) body)
          .status(status.value())
          .userMessage(GENERIC_ERROR_MESSAGE_END_USER)
          .build();
    }

    return super.handleExceptionInternal(ex, body, headers, status, request);
  }

  @Override
  protected ResponseEntity<Object> handleNoHandlerFoundException(
      NoHandlerFoundException exception,
      HttpHeaders headers,
      HttpStatus status,
      WebRequest request
  ) {
    var detail = String.format(
        "The %s resource, which you tried to access, does not exist.", exception.getRequestURL()
    );

    Error error = this.createErrorBuilder(status, ErrorType.RESOURCE_NOT_FOUND, detail)
        .userMessage(GENERIC_ERROR_MESSAGE_END_USER)
        .build();

    return this.handleExceptionInternal(exception, error, headers, status, request);
  }

  @Override
  protected ResponseEntity<Object> handleHttpMessageNotReadable(
      HttpMessageNotReadableException ex,
      HttpHeaders headers,
      HttpStatus status,
      WebRequest request
  ) {
    Throwable rootCause = ExceptionUtils.getRootCause(ex);

    if (rootCause instanceof InvalidFormatException) {
      return this.handleInvalidFormat((InvalidFormatException) rootCause, headers, status, request);
    } else if (rootCause instanceof PropertyBindingException) {
      return this
          .handlePropertyBinding((PropertyBindingException) rootCause, headers, status, request);
    }

    var detail = "The request body is invalid. Check syntax error.";

    Error error = this.createErrorBuilder(status, ErrorType.INCOMPREHENSIBLE_MESSAGE, detail)
        .userMessage(GENERIC_ERROR_MESSAGE_END_USER)
        .build();

    return this.handleExceptionInternal(ex, error, headers, status, request);
  }

  private ResponseEntity<Object> getExceptionNotFound(
      Exception ex,
      WebRequest request
  ) {
    String detail = ex.getMessage();

    Error error = this.createErrorBuilder(HttpStatus.NOT_FOUND, ErrorType.RESOURCE_NOT_FOUND, detail)
        .userMessage(detail)
        .build();

    return this.handleExceptionInternal(ex, error, new HttpHeaders(), HttpStatus.NOT_FOUND, request);
  }

  private ResponseEntity<Object> handleValidationInternal(
      Exception ex,
      HttpHeaders headers,
      HttpStatus status,
      WebRequest request,
      BindingResult bindingResult
  ) {
    var errorType = ErrorType.INVALID_DATA;
    var detail = "One or more fields are invalid. Fill in correctly and try again.";

    List<Error.Field> errorFields = bindingResult
        .getFieldErrors()
        .stream()
        .map(fieldError -> {
          String message = this.messageSource
              .getMessage(fieldError, LocaleContextHolder.getLocale());

          return Error.Field.builder()
              .name(fieldError.getField())
              .userMessage(message)
              .build();
        }).collect(Collectors.toList());

    Error error = this.createErrorBuilder(status, errorType, detail)
        .userMessage(detail)
        .fields(errorFields)
        .build();

    return this.handleExceptionInternal(ex, error, headers, status, request);
  }

  private ResponseEntity<Object> handlePropertyBinding(
      PropertyBindingException ex,
      HttpHeaders headers,
      HttpStatus status,
      WebRequest request
  ) {
    String path = this.joinPath(ex.getPath());
    var errorType = ErrorType.INCOMPREHENSIBLE_MESSAGE;

    String detail = String.format(
        "The property '%s' does not exist. Correct or remove this property and try again.", path
    );

    Error error = this.createErrorBuilder(status, errorType, detail)
        .userMessage(GENERIC_ERROR_MESSAGE_END_USER)
        .build();

    return this.handleExceptionInternal(ex, error, headers, status, request);
  }

  private ResponseEntity<Object> handleInvalidFormat(
      InvalidFormatException ex,
      HttpHeaders headers,
      HttpStatus status,
      WebRequest request
  ) {
    String path = this.joinPath(ex.getPath());
    var errorType = ErrorType.INCOMPREHENSIBLE_MESSAGE;
    var detail = String.format(
        "The property '%s' was given the value '%s', which is of an invalid type. Correct and enter a value compatible with type %s.",
        path, ex.getValue(), ex.getTargetType().getSimpleName()
    );

    Error error = this.createErrorBuilder(status, errorType, detail)
        .userMessage(GENERIC_ERROR_MESSAGE_END_USER)
        .build();

    return this.handleExceptionInternal(ex, error, headers, status, request);
  }

  private Error.ErrorBuilder createErrorBuilder(
      HttpStatus status,
      ErrorType errorType,
      String detail
  ) {
    return Error.builder()
        .timestamp(OffsetDateTime.now())
        .status(status.value())
        .title(errorType.getTitle())
        .detail(detail);
  }

  private String joinPath(List<JsonMappingException.Reference> references) {
    return references
        .stream()
        .map(JsonMappingException.Reference::getFieldName)
        .collect(Collectors.joining("."));
  }
}