package com.github.thientoan3596.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.github.thientoan3596.jackson.FieldErrorDeserializer;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;

/**
 * Response to client
 *
 * <ul>
 *   <li>message: general message
 *   <li>error: general error message
 *   <li>status: {@link HttpStatus}
 *   <li>isFormValidationError: indicating if this should be used in form validation (default is
 *       false)
 *   <li>errors: List of {@link FieldError} (apply{@link JsonDeserialize})
 * </ul>
 */
@SuppressWarnings("ALL")
public class ErrorResponseDTO {
  private String message;
  private String error;
  private HttpStatus status;
  private boolean isFormValidationError = false;

  @JsonDeserialize(contentUsing = FieldErrorDeserializer.class)
  private List<FieldError> errors;

  public ErrorResponseDTO() {}

  public ErrorResponseDTO(
      String message,
      String error,
      HttpStatus status,
      boolean isFormValidationError,
      List<FieldError> errors) {
    this.message = message;
    this.error = error;
    this.status = status;
    this.isFormValidationError = isFormValidationError;
    this.errors = errors;
  }

  private ErrorResponseDTO(ErrorResponseDTOBuilder builder) {
    this.message = builder.message;
    this.error = builder.error;
    this.status = builder.status;
    this.isFormValidationError = builder.isFormValidationError;
    this.errors = builder.errors;
  }

  public static ErrorResponseDTOBuilder builder() {
    return new ErrorResponseDTOBuilder();
  }

  // region @Builder
  public static class ErrorResponseDTOBuilder {
    private String message;
    private String error;
    private HttpStatus status;
    private boolean isFormValidationError = false;
    private List<FieldError> errors;

    ErrorResponseDTOBuilder() {}

    public ErrorResponseDTOBuilder message(String message) {
      this.message = message;
      return this;
    }

    public ErrorResponseDTOBuilder error(String error) {
      this.error = error;
      return this;
    }

    public ErrorResponseDTOBuilder status(HttpStatus status) {
      this.status = status;
      return this;
    }

    public ErrorResponseDTOBuilder isFormValidationError(boolean isFormValidationError) {
      this.isFormValidationError = isFormValidationError;
      return this;
    }

    public ErrorResponseDTOBuilder errors(List<FieldError> errors) {
      this.errors = errors;
      return this;
    }

    public ErrorResponseDTO build() {
      return new ErrorResponseDTO(this);
    }
  }

  // endregion @Builder
  // region @Data
  public String getMessage() {

    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public String getError() {
    return error;
  }

  public void setError(String error) {
    this.error = error;
  }

  public HttpStatus getStatus() {
    return status;
  }

  public void setStatus(HttpStatus status) {
    this.status = status;
  }

  public boolean isFormValidationError() {
    return isFormValidationError;
  }

  public void setFormValidationError(boolean formValidationError) {
    isFormValidationError = formValidationError;
  }

  public List<FieldError> getErrors() {
    return errors;
  }

  public void setErrors(List<FieldError> errors) {
    this.errors = errors;
  }
  // endregion @Data
}
