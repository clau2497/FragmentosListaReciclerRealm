package com.example.practicafragmentos20.ListaRecicler;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import com.example.practicafragmentos20.Adapter.NavigationDelegate;
import com.example.practicafragmentos20.R;
import java.util.ArrayList;

public class adapterBotonRecycler extends RecyclerView.Adapter<adapterBotonRecycler.ViewHolder> {
    public ArrayList<modeloTipoBoton> listaData;

    CallFragments callFragments = new CallFragments();
    NavigationDelegate navigationDelegate;


    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        Spinner spinner;
        Button btn;
        Spinner textSpinner;

        public ViewHolder(View view) {
            super(view);
            // Define click listener for the ViewHolder's View
            name = (TextView) view.findViewById(R.id.name);
            spinner = (Spinner) view.findViewById(R.id.spinner);
            textSpinner = (Spinner) view.findViewById(R.id.spinner);
            btn = (Button) view.findViewById(R.id.btn);

        }
    }

    public adapterBotonRecycler(ArrayList<modeloTipoBoton> listaData, NavigationDelegate navigationDelegate) {
        this.listaData = listaData;
        this.navigationDelegate = navigationDelegate;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View vista = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_button, parent, false);
        return new ViewHolder(vista);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.name.setText(listaData.get(position).getNombre());
        holder.btn.setText(listaData.get(position).getTextSpinner());
        String[] opciones = {"Registro", "Resumen"};
        ArrayAdapter<String> aSpinner = new ArrayAdapter<>(holder.spinner.getContext(), android.R.layout.simple_spinner_item, opciones);
        holder.spinner.setAdapter(aSpinner);
        holder.spinner.setSelection(listaData.get(position).getPosicionSpinner());
        holder.spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String tipo = (String) holder.spinner.getSelectedItem();
                String textSpinner = (String) holder.spinner.getSelectedItem().toString();
                holder.btn.setText(tipo);
                listaData.set(position, new modeloTipoBoton(listaData.get(position).getNombre(), i, textSpinner));

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        holder.btn.setOnClickListener(view -> {
            String tipo = listaData.get(position).getTextSpinner();
            if (Opciones.fromValue(tipo) == Opciones.REGISTRAR) {
                navigationDelegate.popRegistroFragmento();
            } else if (Opciones.fromValue(tipo) == Opciones.RESUMEN) {
                navigationDelegate.popResumenFragmento();
            }
        });

    }

    @Override
    public int getItemCount() {
        return listaData.size();
    }

    public enum Opciones {
        REGISTRAR("Registro"),
        RESUMEN("Resumen");

        private String value;

        Opciones(String value) {
            this.value = value;
        }

        @NonNull
        @Override
        public String toString() {
            return String.valueOf(value);
        }

        @Nullable
        public static Opciones fromValue(String text) {
            for (Opciones b : Opciones.values()) {
                if (String.valueOf(b.value).equals(text)) {
                    return b;
                }
            }
            return null;
        }
    }

}
