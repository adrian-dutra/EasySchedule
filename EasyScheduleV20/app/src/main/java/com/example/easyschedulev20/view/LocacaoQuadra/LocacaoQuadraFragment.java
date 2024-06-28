package com.example.easyschedulev20.view.LocacaoQuadra;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.easyschedulev20.R;

public class LocacaoQuadraFragment extends Fragment {

    private LocacaoQuadraViewModel mViewModel;

    public static LocacaoQuadraFragment newInstance() {
        return new LocacaoQuadraFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_locacao_quadra, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(LocacaoQuadraViewModel.class);
        // TODO: Use the ViewModel
    }

}