package com.example.practicafragmentos20.api.factory;

import android.content.Context;
import com.example.practicafragmentos20.api.Api;
import com.example.practicafragmentos20.api.converter.GetBeneficiaryDataResponseConverter;
import com.example.practicafragmentos20.api.converter.GetClientDataResponseConverter;
import com.example.practicafragmentos20.api.provider.RetrofitWebServiceDataProvider;
import com.example.practicafragmentos20.api.validator.GetBeneficiaryDataResponseValidator;
import com.example.practicafragmentos20.api.validator.GetClientDataResponseValidator;
import com.example.practicafragmentos20.api.vo.BeneficiaryRequest;
import com.example.practicafragmentos20.api.vo.GetBeneficiaryResponse;
import com.example.practicafragmentos20.api.vo.GetClientDataResponse;
import com.example.practicafragmentos20.data.factory.DataProviderFactory;
import com.example.practicafragmentos20.data.provider.Provider;

import retrofit2.http.Body;

public class RetrofitDataProviderFactory extends DataProviderFactory {
    private RequestFactory requestFactory;
    public RetrofitDataProviderFactory(Context context) {
        requestFactory = new RequestFactory();
    }

    @Override
    public Provider<GetClientDataResponse> createGetClientDataProvider(String searchClientEntity) {
        return new RetrofitWebServiceDataProvider<>(
            Api.getClient().getClientData(searchClientEntity, null, null),
            new GetClientDataResponseConverter(),
            new GetClientDataResponseValidator()
        );
    }

    @Override
    public Provider<GetBeneficiaryResponse> getBeneficiaryData(BeneficiaryRequest beneficiaryRequest) {

       return new RetrofitWebServiceDataProvider<>(
                Api.getClient().getBeneficiaryData(beneficiaryRequest),
                new GetBeneficiaryDataResponseConverter(),
                new GetBeneficiaryDataResponseValidator()
        );

    }

//mandar el API





}
