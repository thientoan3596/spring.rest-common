package com.github.thientoan3596.exception;

@SuppressWarnings("unused")
public abstract class BaseException extends RuntimeException {
  private String fieldName;
  private String modelName;
  private String rejectedValue;

  public BaseException(String message, String fieldName, String modelName, String rejectedValue) {
    super(message);
    this.fieldName = fieldName;
    this.modelName = modelName;
    this.rejectedValue = rejectedValue;
  }

  // region @Data
  public String getFieldName() {
    return fieldName;
  }

  public void setFieldName(String fieldName) {
    this.fieldName = fieldName;
  }

  public String getModelName() {
    return modelName;
  }

  public void setModelName(String modelName) {
    this.modelName = modelName;
  }

  public String getRejectedValue() {
    return rejectedValue;
  }

  public void setRejectedValue(String rejectedValue) {
    this.rejectedValue = rejectedValue;
  }
  // endregion @Data
}
