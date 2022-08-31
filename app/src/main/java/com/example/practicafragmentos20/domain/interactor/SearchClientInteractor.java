package com.example.practicafragmentos20.domain.interactor;

import com.example.practicafragmentos20.api.vo.BeneficiaryRequest;
import com.example.practicafragmentos20.api.vo.GetBeneficiaryResponse;
import com.example.practicafragmentos20.api.vo.GetClientDataResponse;
import com.example.practicafragmentos20.base.InteractorBase;
import com.example.practicafragmentos20.contract.SearchClientContract;
import com.example.practicafragmentos20.data.factory.DataProviderFactory;
import com.example.practicafragmentos20.data.factory.RepositoryFactory;
import com.example.practicafragmentos20.data.provider.Provider;
import io.reactivex.Completable;
import io.reactivex.CompletableEmitter;
import io.reactivex.CompletableObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class SearchClientInteractor extends InteractorBase<SearchClientContract.Presenter> implements SearchClientContract.Interactor{

    private RepositoryFactory repositoryFactory;
    private DataProviderFactory webServiceProviderFactory;

    public SearchClientInteractor(DataProviderFactory webServiceProviderFactory) {
        this.repositoryFactory = repositoryFactory;
        this.webServiceProviderFactory = webServiceProviderFactory;
    }
    String nombre = "";

    @Override
    public void searchClient(String searchClientDto) {

        Completable
                .create( (CompletableEmitter emitter) -> {

                    Provider<GetClientDataResponse> clientDataProvider;
                    clientDataProvider = webServiceProviderFactory.createGetClientDataProvider(searchClientDto);
                    clientDataProvider.subscribe(new Provider.Subscriber<GetClientDataResponse>() {
                        @Override
                        public void onError(Throwable exception) {
                            emitter.onError(exception);
                        }

                        @Override
                        public void onSuccess(GetClientDataResponse results) {
                            //respuesta de servicio
                            // final GetClientDataResponse results1 = results;
                            String nombre2 = results.getItems().stream().findFirst().get().getName().toString();
                            String apellidoPaterno = results.getItems().stream().findFirst().get().getFatherLastName().toString();
                            String apellidoMaterno = results.getItems().stream().findFirst().get().getMotherLastName().toString();
                            //concatenar varlor y regresarlo
                            nombre = nombre2 +" "+ apellidoPaterno +" "+ apellidoMaterno;
                            // no recomendable String Name = results.getItems().get(0).getName();
                            /*
                            List<ClientEntity> filteredResults;
                            filteredResults = new ArrayList<>();
                            for (ClientEntity result : results) {
                                if (result.getAccountValidity().equals(Constants.ACCOUNT_VALIDITY_VALID)) {
                                    filteredResults.add(result);
                                }
                            }
                            clientRepository.addAll(filteredResults);*/
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

                        presenter.onResultSearch(nombre);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {

                    }
                });
    }





}