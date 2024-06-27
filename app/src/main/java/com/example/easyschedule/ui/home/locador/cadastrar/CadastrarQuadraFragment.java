package com.example.easyschedule.ui.home.locador.cadastrar;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.easyschedulemob.R;

public class CadastrarQuadraFragment extends Fragment {

    private CadastrarQuadraViewModel mViewModel;

    public static CadastrarQuadraFragment newInstance() {
        return new CadastrarQuadraFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_cadastrar_quadra, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(CadastrarQuadraViewModel.class);
        // TODO: Use the ViewModel
    }

}