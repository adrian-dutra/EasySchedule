package com.example.easyschedulev20.view.locatario.ui.locacoes;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.easyschedulev20.databinding.FragmentLocacaoQuadraLocatarioBinding;


public class LocacaoQuadraLocatarioFragment extends Fragment {

    private FragmentLocacaoQuadraLocatarioBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        LocacaoQuadraLocatarioViewModel locacaoQuadraLocatarioViewModel =
                new ViewModelProvider(this).get(LocacaoQuadraLocatarioViewModel.class);

        binding = FragmentLocacaoQuadraLocatarioBinding.inflate(inflater, container, false);
        View root = binding.getRoot();


        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}