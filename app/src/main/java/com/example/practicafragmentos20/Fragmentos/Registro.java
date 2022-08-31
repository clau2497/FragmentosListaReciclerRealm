package com.example.practicafragmentos20.Fragmentos;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.practicafragmentos20.Adapter.NavigationAdapter;
import com.example.practicafragmentos20.R;
import com.example.practicafragmentos20.databinding.FragmentRegistroBinding;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Registro#newInstance} com.example.practicafragmentos20.data.com.example.practicafragmentos20.api.com.example.practicafragmentos20.database.factory method to
 * create an instance of this fragment.
 */
public class Registro extends NavigationAdapter.Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    FragmentRegistroBinding viewDataBinding;


    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Registro() {
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
    public static Registro newInstance(String param1, String param2) {
        Registro fragment = new Registro();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_registro, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewDataBinding = DataBindingUtil.bind(view);
        viewDataBinding.back.setOnClickListener(view1 -> {
            navigationDelegate.popBackToRecicler();
        });
    }
}