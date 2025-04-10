package com.github.thientoan3596.exception;

@SuppressWarnings("unused")
public class UnmodifiableEntityException extends  BaseException{
    public UnmodifiableEntityException(String message, String fieldName, String modelName, String rejectedValue) {
        super(message,fieldName,modelName,rejectedValue);
    }
}
