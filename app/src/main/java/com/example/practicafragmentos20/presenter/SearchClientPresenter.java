package com.example.practicafragmentos20.presenter;

import android.text.Editable;

import com.example.practicafragmentos20.api.vo.BeneficiaryRequest;
import com.example.practicafragmentos20.base.PresenterBase;
import com.example.practicafragmentos20.contract.SearchClientContract;

import java.util.ArrayList;
import java.util.List;


public class SearchClientPresenter extends PresenterBase<SearchClientContract.Interactor, SearchClientContract.State, SearchClientContract.View>
    implements SearchClientContract.Presenter {
    @Override
    public void onClickSearch(String numeroCuenta) {

/*
        if (searchClientDto.getAccountNumber().isEmpty()) {
            searchClientDto.setAccountNumber(null);
        }

        if (searchClientDto.getCurp().isEmpty()) {
            searchClientDto.setCurp(null);
        }

        if (searchClientDto.getNss().isEmpty()) {
            searchClientDto.setNss(null);
        }

        if (searchClientDto.getAccountNumber() != null && !searchClientDto.getAccountNumber().isEmpty()) {
            */

            interactor.searchClient(numeroCuenta);

      /*  } else if (searchClientDto.getCurp() != null && !searchClientDto.getCurp().isEmpty()) {
            com.example.practicafragmentos20.domain.interactor.validateCurp(searchClientDto);
        } else if (searchClientDto.getNss() != null && !searchClientDto.getNss().isEmpty()) {
            com.example.practicafragmentos20.domain.interactor.validateNss(searchClientDto);
        } else {
            view.showEmptySearchClientDataError();
            view.dismissLoading();
        }*/
    }
    @Override
    public  void onResultSearch(String nombre){
        view.onResultSearchFragment(nombre);
    }
}
