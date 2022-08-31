package com.example.practicafragmentos20.Adapter;

import java.util.HashMap;

public class NavigationState<T> {
    public static final String PAGE_RECICLER_FRAGMENTO = "PAGE_RECICLER_FRAGMENTO";
    public static final String PAGE_RESUMEN_FRAGMENTO = "PAGE_RESUMEN_FRAGMENTO";
    public static final String PAGE_REGISTRO_FRAGMENTO = "PAGE_REGISTRO_FRAGMENTO";


    private HashMap<String, T> state = new HashMap<>();

    public T getState(String page) {
        return state.get(page);
    }

    public void putState(String page, T state) {
        this.state.put(page, state);
    }
}
