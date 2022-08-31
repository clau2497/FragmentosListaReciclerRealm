package com.example.practicafragmentos20.data.dao;
import java.util.UUID;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class ModeloPersona extends RealmObject{

    @PrimaryKey
    private String id = UUID.randomUUID().toString();

    String nombre;
    int tipoPago;
    boolean selecionado;

    public ModeloPersona(){}

    public boolean isSelecionado() {
        return selecionado;
    }

    public void setSelecionado(boolean selecionado) {
        this.selecionado = selecionado;
    }

    public ModeloPersona(String nombre, int tipoPago, boolean selecionado) {
        this.nombre = nombre;
        this.tipoPago = tipoPago;
        this.selecionado = selecionado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getTipoPago() {
        return tipoPago;
    }

    public void setTipoPago(int tipoPago) {
        this.tipoPago = tipoPago;
    }
}
