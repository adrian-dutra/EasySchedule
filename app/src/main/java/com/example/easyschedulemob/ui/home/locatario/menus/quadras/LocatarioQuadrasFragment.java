package com.example.easyschedulemob.ui.home.locatario.menus.quadras;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.easyschedulemob.databinding.FragmentQuadrasLocatarioBinding;

public class LocatarioQuadrasFragment extends Fragment {

    private FragmentQuadrasLocatarioBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        LocatarioViewModel locatarioViewModel =
                new ViewModelProvider(this).get(LocatarioViewModel.class);

        binding = FragmentQuadrasLocatarioBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textHome;
        locatarioViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}