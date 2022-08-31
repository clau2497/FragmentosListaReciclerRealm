package com.example.practicafragmentos20.base;

public class InteractorBase<TPresenter extends ContractBase.Presenter> implements ContractBase.Interactor<TPresenter> {
    protected TPresenter presenter;

    @Override
    public void resume() {

    }

    @Override
    public void setPresenter(TPresenter presenter) {
        this.presenter = presenter;
    }
}
