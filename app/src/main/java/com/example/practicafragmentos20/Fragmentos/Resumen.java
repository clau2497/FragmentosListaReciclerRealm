package com.example.practicafragmentos20.Fragmentos;
import android.annotation.SuppressLint;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;

import com.example.practicafragmentos20.Adapter.NavigationAdapter;
import com.example.practicafragmentos20.ListaRecicler.adapterBotonRecycler;
import com.example.practicafragmentos20.ListaRecicler.modeloTipoBoton;
import com.example.practicafragmentos20.R;
import com.example.practicafragmentos20.api.factory.RetrofitDataProviderFactory;
import com.example.practicafragmentos20.contract.SearchClientContract;
import com.example.practicafragmentos20.databinding.FragmentResumenBinding;
import com.example.practicafragmentos20.domain.dto.SearchClientDto;
import com.example.practicafragmentos20.domain.interactor.SearchClientInteractor;
import com.example.practicafragmentos20.presenter.SearchClientPresenter;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Registro#newInstance} com.example.practicafragmentos20.data.com.example.practicafragmentos20.api.com.example.practicafragmentos20.database.factory method to
 * create an instance of this fragment.
 */
public class Resumen extends NavigationAdapter.Fragment implements SearchClientContract.View {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    FragmentResumenBinding viewDataBinding;
    private SearchClientContract.Presenter presenter;
    private String numeroCuentaIngresado;


    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Resumen() {
        // Required empty public constructor
    }

    /**
     * Use this com.example.practicafragmentos20.data.com.example.practicafragmentos20.api.com.example.practicafragmentos20.database.factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BlankFragmentPrimero.
     */
    // TODO: Rename and change types and number of parameters
    public static Resumen newInstance(String param1, String param2) {
        Resumen fragment = new Resumen();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SearchClientContract.Interactor interactor;
        interactor = new SearchClientInteractor(new RetrofitDataProviderFactory(getContext()));
        presenter = new SearchClientPresenter();
        presenter.setInteractor(interactor);
        presenter.setView(this);
        interactor.setPresenter(presenter);
        //String numeroCuenta = "1340001375";
       // presenter.onClickSearch(numeroCuenta);
        setResettable(true);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_resumen, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewDataBinding = DataBindingUtil.bind(view);
        viewDataBinding.back.setOnClickListener(view1 -> {
            navigationDelegate.popBackToRecicler();
        });


    }

    private View.OnClickListener searchButtonOnClickListener = v -> {
        String numeroCuenta;
        numeroCuenta = viewDataBinding.txtNumeroCuenta.getText().toString();
        /*maneras de convertir un valor a string
        //numeroCuenta = String.valueOf(viewDataBinding.txtNumeroCuenta.getText());
        //numeroCuenta = viewDataBinding.txtNumeroCuenta.getText() + "";*/
        presenter.onClickSearch(numeroCuenta);


    };

    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        viewDataBinding.btnBuscarCuenta.setOnClickListener(searchButtonOnClickListener);
    }

    @Override
    public void onResultSearchFragment(String nombre ) {
        //manadar en un label
        viewDataBinding.textoServicio.setText(nombre);
        System.out.println(nombre + " Ya llegamos aqui");

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
}