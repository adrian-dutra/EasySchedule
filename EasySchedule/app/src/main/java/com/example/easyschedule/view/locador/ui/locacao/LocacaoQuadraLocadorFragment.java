package com.example.easyschedule.view.locador.ui.locacao;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;


import com.example.easyschedule.databinding.FragmentLocacaoQuadraLocadorBinding;

public class LocacaoQuadraLocadorFragment extends Fragment {

    private FragmentLocacaoQuadraLocadorBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        LocacaoQuadraLocadorViewModel locacaoQuadraLocadorViewModel =
                new ViewModelProvider(this).get(LocacaoQuadraLocadorViewModel.class);

        binding = FragmentLocacaoQuadraLocadorBinding.inflate(inflater, container, false);
        View root = binding.getRoot();


        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}