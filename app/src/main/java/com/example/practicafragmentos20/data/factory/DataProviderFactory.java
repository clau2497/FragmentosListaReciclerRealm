package com.example.practicafragmentos20.data.factory;

import com.example.practicafragmentos20.api.vo.BeneficiaryRequest;
import com.example.practicafragmentos20.api.vo.GetBeneficiaryResponse;
import com.example.practicafragmentos20.api.vo.GetClientDataResponse;
import com.example.practicafragmentos20.data.provider.Provider;

public abstract class DataProviderFactory {

    public abstract Provider<GetClientDataResponse> createGetClientDataProvider(String searchClientEntity);

    public abstract Provider<GetBeneficiaryResponse> getBeneficiaryData(BeneficiaryRequest beneficiaryRequest);

}
