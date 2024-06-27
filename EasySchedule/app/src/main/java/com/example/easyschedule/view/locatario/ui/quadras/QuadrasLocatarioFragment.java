package com.example.easyschedule.view.locatario.ui.quadras;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.easyschedule.databinding.FragmentQuadrasLocatarioBinding;

public class QuadrasLocatarioFragment extends Fragment {

    private FragmentQuadrasLocatarioBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        QuadrasLocatarioViewModel quadrasLocatarioViewModel =
                new ViewModelProvider(this).get(QuadrasLocatarioViewModel.class);

        binding = FragmentQuadrasLocatarioBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textHome;
        quadrasLocatarioViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}