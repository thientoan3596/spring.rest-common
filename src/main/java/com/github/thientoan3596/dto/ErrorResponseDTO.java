package com.github.thientoan3596.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.github.thientoan3596.jackson.FieldErrorDeserializer;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;

import java.util.List;
@SuppressWarnings("ALL")
public class ErrorResponseDTO {
    private String message;
    private String error;
    private HttpStatus status;
    private boolean isFormValidationError=false;
    @JsonDeserialize(contentUsing = FieldErrorDeserializer.class)
    private List<FieldError> errors;
    public ErrorResponseDTO() {}
    public ErrorResponseDTO(String message, String error, HttpStatus status, boolean isFormValidationError, List<FieldError> errors) {
        this.message = message;
        this.error = error;
        this.status = status;
        this.isFormValidationError = isFormValidationError;
        this.errors = errors;
    }
    private ErrorResponseDTO(Builder builder) {
        this.message = builder.message;
        this.error = builder.error;
        this.status = builder.status;
        this.isFormValidationError = builder.isFormValidationError;
        this.errors = builder.errors;
    }
    //region @Builder
    public static class Builder {
        private String message;
        private String error;
        private HttpStatus status;
        private boolean isFormValidationError = false;
        private List<FieldError> errors;
        public Builder message(String message) {
            this.message = message;
            return this;
        }
        public Builder error(String error) {
            this.error = error;
            return this;
        }
        public Builder status(HttpStatus status) {
            this.status = status;
            return this;
        }
        public Builder isFormValidationError(boolean isFormValidationError) {
            this.isFormValidationError = isFormValidationError;
            return this;
        }
        public Builder errors(List<FieldError> errors) {
            this.errors = errors;
            return this;
        }
        public ErrorResponseDTO build() {
            return new ErrorResponseDTO(this);
        }
    }
    //endregion @Builder
    //region @Data
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
    //endregion @Data
}
