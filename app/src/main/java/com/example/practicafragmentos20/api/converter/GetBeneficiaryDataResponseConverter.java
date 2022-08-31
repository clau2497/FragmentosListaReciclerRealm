package com.example.practicafragmentos20.api.converter;

import com.example.practicafragmentos20.api.vo.GetBeneficiaryResponse;
public class GetBeneficiaryDataResponseConverter extends ResponseConverter<GetBeneficiaryResponse, GetBeneficiaryResponse> {

    @Override
    public GetBeneficiaryResponse convert(GetBeneficiaryResponse getBeneficiaryResponse) {
        return getBeneficiaryResponse;
    }
}
