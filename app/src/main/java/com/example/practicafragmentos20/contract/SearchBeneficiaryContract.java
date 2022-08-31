package com.example.practicafragmentos20.contract;

import com.example.practicafragmentos20.api.vo.BeneficiaryRequest;
import com.example.practicafragmentos20.api.vo.GetBeneficiaryResponse;
import com.example.practicafragmentos20.base.ContractBase;

public interface SearchBeneficiaryContract {
    interface Interactor extends ContractBase.Interactor<SearchBeneficiaryContract.Presenter>{
        void Beneficiaries(BeneficiaryRequest beneficiary);
        //void onResponseBeneficiary(GetBeneficiaryResponse beneficiaryResponse);
    }

    interface Presenter extends ContractBase.Presenter<Interactor,State, View>{
        void beneficiariesSearch(BeneficiaryRequest beneficiary);
        void onResponseBeneficiary(GetBeneficiaryResponse beneficiaryResponse);

    }

    interface State extends ContractBase.State{

    }

    interface View extends ContractBase.View{
        void onConsultBeneficiary(GetBeneficiaryResponse beneficiaryResponse);
    }
}
