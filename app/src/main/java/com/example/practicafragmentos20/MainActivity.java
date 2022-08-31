package com.example.practicafragmentos20;


import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.LifecycleOwner;
import androidx.viewpager.widget.ViewPager;
import androidx.lifecycle.DefaultLifecycleObserver;
import android.os.Bundle;
import android.view.View;
import com.example.practicafragmentos20.Adapter.ActivityBase;
import com.example.practicafragmentos20.Adapter.NavigationAdapter;
import com.example.practicafragmentos20.Adapter.NavigationDelegate;
import com.example.practicafragmentos20.Adapter.NavigationState;
import com.example.practicafragmentos20.Fragmentos.Recicler;
import com.example.practicafragmentos20.Fragmentos.Registro;
import com.example.practicafragmentos20.Fragmentos.Resumen;
import com.example.practicafragmentos20.databinding.ActivityMainBinding;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class MainActivity extends ActivityBase implements  NavigationDelegate<Bundle>{

    private ActivityMainBinding viewDataBinding;
    private NavigationAdapter navigationAdapter;
    private NavigationState<Integer> navigationState;
    private int currentFragmentPosition = -1;
    private boolean popPending;
    private boolean showTimelinePending;
    private boolean isPopInitialCapture;

    private androidx.viewpager.widget.ViewPager.OnPageChangeListener onPageChangeListener = new androidx.viewpager.widget.ViewPager.SimpleOnPageChangeListener(){
        @Override
        public void onPageSelected(final int position) {
            if (!popPending) {
                NavigationAdapter.Fragment fragment;
                fragment = navigationAdapter.getItem(position);

                if (!fragment.isBackEnabled()) {
                    viewDataBinding.navigationViewPager.setCurrentItem(currentFragmentPosition, true);
                } else {
                    currentFragmentPosition = position;
                }
                fragment.resumeFragment();
                fragment.setFragmentResumed(true);

                navigationAdapter.getItem(position).getLifecycle().addObserver(new DefaultLifecycleObserver() {
                    @Override
                    public void onResume(@NonNull LifecycleOwner owner) {
                        NavigationAdapter.Fragment fragment;
                        fragment = navigationAdapter.getItem(position);

                        if (!fragment.isFragmentResumed()) {
                            fragment.resumeFragment();
                            fragment.setFragmentResumed(true);
                        }
                    }
                });
            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {
            if (popPending && state == ViewPager.SCROLL_STATE_IDLE) {
                navigationAdapter.popUpTo(currentFragmentPosition);
                if (!isPopInitialCapture){
                }else {
                    isPopInitialCapture = false;
                }
                popPending = false;
                NavigationAdapter.Fragment fragment;
                fragment = navigationAdapter.getItem(currentFragmentPosition);

                if (fragment.isResettable()) {
                    fragment.reset();
                }
            } else if (showTimelinePending && state == ViewPager.SCROLL_STATE_IDLE) {
                showTimelinePending = false;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Realm.init(this);
        RealmConfiguration config = new RealmConfiguration.Builder()
                .deleteRealmIfMigrationNeeded()
                .build();
        Realm.setDefaultConfiguration(config);
        navigationAdapter = new NavigationAdapter(getSupportFragmentManager());
        navigationState = new NavigationState<>();
        viewDataBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        viewDataBinding.navigationViewPager.addOnPageChangeListener(onPageChangeListener);
        viewDataBinding.navigationViewPager.setAdapter(navigationAdapter);
        viewDataBinding.navigationViewPager.setVisibility(View.VISIBLE);
        fragmentoInicial();
    }

    public  void fragmentoInicial(){
        Recicler inicialFragment = new Recicler();
        inicialFragment.setNavigationDelegate(this);
        int fragmentPosition;
        fragmentPosition = navigationAdapter.pushFragment(inicialFragment);
        navigationState.putState(NavigationState.PAGE_RECICLER_FRAGMENTO, fragmentPosition);
        onPageChangeListener.onPageSelected(0);
    }

    @Override
    public void popResumenFragmento() {
        //navigationAdapter.clear();
        Resumen segundofragment = new Resumen();
        segundofragment.setNavigationDelegate(this);
        int fragmentPosition;
        fragmentPosition = navigationAdapter.pushFragment(segundofragment);
        showTimelinePending = true;
        navigationState.putState(NavigationState.PAGE_RESUMEN_FRAGMENTO, fragmentPosition);
        viewDataBinding.navigationViewPager.setCurrentItem(fragmentPosition, true);
    }

    @Override
    public void popRegistroFragmento() {
        //navigationAdapter.clear();
        Registro inicialFragment = new Registro();
        inicialFragment.setNavigationDelegate(this);
        int fragmentPosition;
        fragmentPosition = navigationAdapter.pushFragment(inicialFragment);
        navigationState.putState(NavigationState.PAGE_REGISTRO_FRAGMENTO, fragmentPosition);
        viewDataBinding.navigationViewPager.setCurrentItem(fragmentPosition, true);
    }
    @Override
    public void popBackToRecicler(){
        int fragmentPosition;
        fragmentPosition = navigationState.getState(NavigationState.PAGE_RECICLER_FRAGMENTO);
        currentFragmentPosition = fragmentPosition;
        popPending = true;
        viewDataBinding.navigationViewPager.setCurrentItem(fragmentPosition, true);

    }
    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }
}