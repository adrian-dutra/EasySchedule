package com.example.easyschedule.view.locador.ui.quadras;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.easyschedule.databinding.FragmentQuadrasLocadorBinding;

public class QuadrasLocadorFragment extends Fragment {

    private FragmentQuadrasLocadorBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        QuadrasLocadorViewModel quadrasLocadorViewModel =
                new ViewModelProvider(this).get(QuadrasLocadorViewModel.class);

        binding = FragmentQuadrasLocadorBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textHome;
        quadrasLocadorViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}