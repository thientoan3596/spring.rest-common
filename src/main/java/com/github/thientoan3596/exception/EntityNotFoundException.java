package com.github.thientoan3596.exception;

@SuppressWarnings("unused")
public class EntityNotFoundException extends BaseException {
    public EntityNotFoundException(String message, String fieldName, String modelName, String rejectedValue) {
        super(message, fieldName, modelName, rejectedValue);
    }
}
