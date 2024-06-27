package com.example.easyschedule.ui.home.locador.menus.quadras;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.easyschedulemob.databinding.FragmentHomeBinding;
import com.example.easyschedulemob.databinding.FragmentQuadrasBinding;

public class QuadrasFragment extends Fragment {

    private FragmentQuadrasBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        QuadrasViewModel quadrasViewModel =
                new ViewModelProvider(this).get(QuadrasViewModel.class);

        binding = FragmentQuadrasBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textHome;
        quadrasViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}