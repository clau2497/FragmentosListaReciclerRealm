package com.example.practicafragmentos20.ListaRecicler;

import com.example.practicafragmentos20.Adapter.NavigationAdapter;

public class CallFragments extends NavigationAdapter.Fragment {


    public void openRegister(){
        navigationDelegate.popRegistroFragmento();
    }
    public void openResumen(){
        navigationDelegate.popResumenFragmento();
    }
}
