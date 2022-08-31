package com.example.practicafragmentos20.domain.interactor;

import com.example.practicafragmentos20.api.vo.BeneficiaryRequest;
import com.example.practicafragmentos20.api.vo.GetBeneficiaryResponse;
import com.example.practicafragmentos20.base.InteractorBase;
import com.example.practicafragmentos20.contract.SearchBeneficiaryContract;
import com.example.practicafragmentos20.data.factory.DataProviderFactory;
import com.example.practicafragmentos20.data.factory.RepositoryFactory;
import com.example.practicafragmentos20.data.provider.Provider;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Completable;
import io.reactivex.CompletableEmitter;
import io.reactivex.CompletableObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class SearchBeneficiaryInteractor  extends InteractorBase<SearchBeneficiaryContract.Presenter> implements SearchBeneficiaryContract.Interactor {
    private DataProviderFactory webServiceProviderFactory;
    private GetBeneficiaryResponse response;
    public SearchBeneficiaryInteractor(DataProviderFactory webServiceProviderFactory) {
        this.webServiceProviderFactory = webServiceProviderFactory;
    }

    @Override
    public void Beneficiaries(BeneficiaryRequest beneficiary) {
        Completable
                .create( (CompletableEmitter emitter) -> {

                    Provider<GetBeneficiaryResponse> beneficiaryDataProvider;
                    beneficiaryDataProvider = webServiceProviderFactory.getBeneficiaryData(beneficiary);
                    beneficiaryDataProvider.subscribe(new Provider.Subscriber<GetBeneficiaryResponse>() {
                        @Override
                        public void onError(Throwable exception) {
                            emitter.onError(exception);
                        }

                        @Override
                        public void onSuccess(GetBeneficiaryResponse beneficiaryResponse) {

                        response = beneficiaryResponse;
                        emitter.onComplete();

                        }

                    });
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.computation())
                .subscribe(new CompletableObserver() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onComplete() {
                        presenter.onResponseBeneficiary(response);
                        //presenter.beneficiariesSearch(BeneficiaryRequest);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {

                    }
                });

    }


}
