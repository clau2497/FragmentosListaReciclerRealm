package com.example.practicafragmentos20.api.validator;

import com.example.practicafragmentos20.api.vo.GetBeneficiaryResponse;

public class GetBeneficiaryDataResponseValidator extends ResponseValidator<GetBeneficiaryResponse> {
    @Override
    public boolean validate(GetBeneficiaryResponse response) {
        if (response == null) {
            return false;
        }

        if (response.getListaBeneficiarios() == null) {
            return false;
        }

        if (response.getListaBeneficiarios().isEmpty()) {
            return false;
        }

        return true;
    }

}
