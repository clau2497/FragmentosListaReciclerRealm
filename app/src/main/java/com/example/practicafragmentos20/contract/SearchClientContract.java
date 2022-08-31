package com.example.practicafragmentos20.contract;
import com.example.practicafragmentos20.api.vo.BeneficiaryRequest;
import com.example.practicafragmentos20.api.vo.GetBeneficiaryResponse;
import com.example.practicafragmentos20.base.ContractBase;

public interface SearchClientContract {
    interface Interactor extends ContractBase.Interactor<Presenter>{
        void searchClient(String searchClientDto);
    }

    interface Presenter extends ContractBase.Presenter<Interactor, State, View>{
        void onClickSearch(String numeroCuenta);
        void onResultSearch(String nombre);

    }

    interface State extends ContractBase.State{

    }

    interface View extends ContractBase.View{
        void onResultSearchFragment(String nombre);




    }
}
