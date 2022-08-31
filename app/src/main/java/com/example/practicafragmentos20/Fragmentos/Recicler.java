package com.example.practicafragmentos20.Fragmentos;

import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.practicafragmentos20.Adapter.NavigationAdapter;
import com.example.practicafragmentos20.ListaRecicler.adapterBotonRecycler;
import com.example.practicafragmentos20.ListaRecicler.modeloTipoBoton;
import com.example.practicafragmentos20.R;
import com.example.practicafragmentos20.api.factory.RetrofitDataProviderFactory;
import com.example.practicafragmentos20.api.vo.BeneficiaryRequest;
import com.example.practicafragmentos20.api.vo.GetBeneficiaryResponse;
import com.example.practicafragmentos20.contract.SearchBeneficiaryContract;
import com.example.practicafragmentos20.data.dao.PersonaDAO;
import com.example.practicafragmentos20.databinding.FragmentReciclerBinding;
import com.example.practicafragmentos20.domain.interactor.SearchBeneficiaryInteractor;
import com.example.practicafragmentos20.model.BeneficiaryModel;
import com.example.practicafragmentos20.presenter.SearchBeneficiaryPresenter;


import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Recicler#newInstance} com.example.practicafragmentos20.data.com.example.practicafragmentos20.api.com.example.practicafragmentos20.database.factory method to
 * create an instance of this fragment.
 */
public class Recicler extends NavigationAdapter.Fragment implements SearchBeneficiaryContract.View {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private adapterBotonRecycler adapter;
    private SearchBeneficiaryContract.Presenter presenter;
    FragmentReciclerBinding viewDataBinding;
    RecyclerView rvLista;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    ArrayList<BeneficiaryRequest> listBeneficiaries;

    public Recicler() {
        // Required empty public constructor
    }


    /**
     * Use this com.example.practicafragmentos20.data.com.example.practicafragmentos20.api.com.example.practicafragmentos20.database.factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Recicler.
     */
    // TODO: Rename and change types and number of parameters
    public static Recicler newInstance(String param1, String param2) {
        Recicler fragment = new Recicler();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }
    /*llenar lista por el metodo anterior
    private void llenarLista(GetBeneficiaryResponse beneficiaryResponse) {
        ArrayList <modeloTipoBoton> listaData = new ArrayList<>();
       // List<GetBeneficiaryResponse.ListaBeneficiario> beneficiaryList = new ArrayList<>();
        for(GetBeneficiaryResponse.ListaBeneficiario beneficiario: beneficiaryResponse.getListaBeneficiarios()){
            String nombre = beneficiario.getNombre() + beneficiario.getApellidoPaterno() + beneficiario.getApellidoMaterno();
            listaData.add(new modeloTipoBoton(nombre, 0,"Resumen"));
        }
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        viewDataBinding.reciclerView.setLayoutManager(layoutManager);
        adapter = new adapterBotonRecycler(listaData, navigationDelegate);
        viewDataBinding.reciclerView.setAdapter(adapter);

        /*ArrayList<modeloTipoBoton> listaData = new ArrayList<>();
        for (int i = 0; i <30 ; i++) {
            listaData.add(new modeloTipoBoton("Clau " + i ,0, "Registro"));
        }*/
    /*
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        viewDataBinding.reciclerView.setLayoutManager(layoutManager);
        adapter = new adapterBotonRecycler(listaData, navigationDelegate);
        viewDataBinding.reciclerView.setAdapter(adapter);
    }
    */

    //llenar lista y guardar en base Realm
    //aqui se procesan los datos sel servicio
    @RequiresApi(api = Build.VERSION_CODES.N)
    private void llenarLista(GetBeneficiaryResponse beneficiaryResponse) {
       PersonaDAO.addAll(beneficiaryResponse);
       // PersonaDAO.getAll(beneficiaryResponse);
        GetBeneficiaryResponse respuestaBeneficiarios = PersonaDAO.getAll();
        ArrayList<modeloTipoBoton> listaData = new ArrayList<>();
        for (GetBeneficiaryResponse.ListaBeneficiario beneficiario : respuestaBeneficiarios.getListaBeneficiarios()) {
            String nombre = beneficiario.getNombre() + beneficiario.getApellidoPaterno() + beneficiario.getApellidoMaterno();
            listaData.add(new modeloTipoBoton(nombre, 0, "Resumen"));
        }
        ///tengo que utilizar la clase de mi responde en lugar de modelopersona
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        viewDataBinding.reciclerView.setLayoutManager(layoutManager);
        //aqui obtiene los seleccionados
        adapter = new adapterBotonRecycler(listaData, navigationDelegate);
        viewDataBinding.reciclerView.setAdapter(adapter);

    }

    /*codigo para aplicar el convertidor*/

    //BeneficiaryModel beneficiaryModel = new BeneficiaryModel("Nombre", );

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SearchBeneficiaryContract.Interactor interactor;
        interactor = new SearchBeneficiaryInteractor(new RetrofitDataProviderFactory(getContext()));
        presenter = new SearchBeneficiaryPresenter();
        presenter.setInteractor(interactor);
        presenter.setView(this);
        interactor.setPresenter(presenter);
        BeneficiaryRequest beneficiaryRequest = new BeneficiaryRequest();
        beneficiaryRequest.setPersonId(152005990L);
        //AQUI SE MANDAN LOS DATOS
        beneficiaryRequest.setRoleKey(6);
        presenter.beneficiariesSearch(beneficiaryRequest);
        setResettable(true);


        PersonaDAO persona = new PersonaDAO();
       // persona.clear();
        GetBeneficiaryResponse ben = new GetBeneficiaryResponse();
       //llenarLista(ben);

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_recicler, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewDataBinding = DataBindingUtil.bind(view);
        //llenarLista();
    }

    @Override
    public void dismissLoading() {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void showNetworkUnavailable() {

    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void onConsultBeneficiary(GetBeneficiaryResponse beneficiaryResponse) {
        llenarLista(beneficiaryResponse);
    }

}