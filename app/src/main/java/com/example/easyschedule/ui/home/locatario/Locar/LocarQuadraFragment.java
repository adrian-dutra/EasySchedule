package com.example.easyschedule.ui.home.locatario.Locar;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.easyschedulemob.R;

public class LocarQuadraFragment extends Fragment {

    private LocarQuadraViewModel mViewModel;

    public static LocarQuadraFragment newInstance() {
        return new LocarQuadraFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_locar_quadra, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(LocarQuadraViewModel.class);
        // TODO: Use the ViewModel
    }

}