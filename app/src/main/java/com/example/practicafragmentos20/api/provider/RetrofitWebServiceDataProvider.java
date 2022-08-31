package com.example.practicafragmentos20.api.provider;



import com.example.practicafragmentos20.api.converter.ResponseConverter;
import com.example.practicafragmentos20.api.validator.ResponseValidator;
import com.example.practicafragmentos20.data.provider.Provider;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Response;

public class RetrofitWebServiceDataProvider<TResponse, TResult> implements Provider<TResult> {
    private Call<TResponse> call;
    private ResponseValidator<TResponse> responseValidator;
    private ResponseConverter<TResponse, TResult> responseConverter;

    public RetrofitWebServiceDataProvider(Call<TResponse> call, ResponseConverter<TResponse, TResult> responseConverter, ResponseValidator<TResponse> responseValidator) {
        this.call = call;
        this.responseValidator = responseValidator;
        this.responseConverter = responseConverter;
    }

    @Override
    public void subscribe(Subscriber<TResult> subscriber) {
        Response<TResponse> response;

        try {
            response = call.execute();

            if (response.isSuccessful()) {
                if (responseValidator.validate(response.body())) {
                    subscriber.onSuccess(responseConverter.convert(response.body()));
                } else {
                    subscriber.onError(new Throwable());
                }
            } else {
                subscriber.onError(new Throwable());
            }
        } catch (IOException exception) {
            subscriber.onError(exception);
        }
    }
}
