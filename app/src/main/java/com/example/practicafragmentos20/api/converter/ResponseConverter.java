package com.example.practicafragmentos20.api.converter;
public abstract class ResponseConverter<TResponse, TResult> {
    public abstract TResult convert(TResponse response);
}
