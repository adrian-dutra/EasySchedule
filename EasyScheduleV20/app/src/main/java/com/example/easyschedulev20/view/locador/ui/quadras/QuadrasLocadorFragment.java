package com.example.easyschedulev20.view.locador.ui.quadras;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.easyschedulev20.databinding.FragmentQuadrasLocadorBinding;
import com.example.easyschedulev20.view.quadras.QuadrasActivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;


public class QuadrasLocadorFragment extends Fragment {

    private FragmentQuadrasLocadorBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        com.example.easyschedule.view.locador.ui.quadras.QuadrasLocadorViewModel quadrasLocadorViewModel =
                new ViewModelProvider(requireActivity()).get(com.example.easyschedule.view.locador.ui.quadras.QuadrasLocadorViewModel.class);

        binding = FragmentQuadrasLocadorBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        FloatingActionButton fab = binding.floatingActionButtonQuadrasLocador;
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navega para a atividade de cadastro de quadra
                Intent intent = new Intent(getActivity(), QuadrasActivity.class);
                startActivity(intent);
            }
        });

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}