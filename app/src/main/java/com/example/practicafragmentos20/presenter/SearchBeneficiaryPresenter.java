package com.example.practicafragmentos20.presenter;

import com.example.practicafragmentos20.api.vo.BeneficiaryRequest;
import com.example.practicafragmentos20.api.vo.GetBeneficiaryResponse;
import com.example.practicafragmentos20.base.PresenterBase;
import com.example.practicafragmentos20.contract.SearchBeneficiaryContract;

public class SearchBeneficiaryPresenter extends PresenterBase<SearchBeneficiaryContract.Interactor, SearchBeneficiaryContract.State, SearchBeneficiaryContract.View>
        implements SearchBeneficiaryContract.Presenter {

    @Override
    public void beneficiariesSearch(BeneficiaryRequest beneficiary) {
        interactor.Beneficiaries(beneficiary);
    }

    @Override
    public void onResponseBeneficiary(GetBeneficiaryResponse beneficiaryResponse) {
        view.onConsultBeneficiary(beneficiaryResponse);
    }

}
