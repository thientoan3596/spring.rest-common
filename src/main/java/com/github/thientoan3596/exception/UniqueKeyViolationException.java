package com.github.thientoan3596.exception;

@SuppressWarnings("unused")
public class UniqueKeyViolationException extends BaseException {
    public UniqueKeyViolationException(String message, String fieldName, String modelName, String rejectedValue) {
        super(message, fieldName, modelName,rejectedValue);
    }
}