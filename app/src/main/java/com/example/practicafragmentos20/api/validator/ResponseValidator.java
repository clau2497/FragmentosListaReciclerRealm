package com.example.practicafragmentos20.api.validator;

public abstract class ResponseValidator<T> {
    public abstract boolean validate(T response);
}
