package com.example.easyschedulev20.view.locador.ui.quadras;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.easyschedulev20.databinding.FragmentQuadrasLocadorBinding;
import com.example.easyschedulev20.model.QuadraEsportiva;
import com.example.easyschedulev20.view.quadras.QuadrasActivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class QuadrasLocadorFragment extends Fragment {

    private FragmentQuadrasLocadorBinding binding;
    private int userId;
    private ListView listView;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        QuadrasLocadorViewModel quadrasLocadorViewModel =
                new ViewModelProvider(requireActivity()).get(QuadrasLocadorViewModel.class);

        binding = FragmentQuadrasLocadorBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        if (getArguments() != null) {
            userId = getArguments().getInt("userId", 0);
        }

        Log.d("warning", "LOCADOOOOOOOR 2!!!!!!! " + userId);
        listView = binding.listViewQuadrasLocador;

        List<QuadraEsportiva> quadras = quadrasLocadorViewModel.listarQuadras(requireActivity().getApplication());
        List<String> nomesQuadras = new ArrayList<>();
        for (QuadraEsportiva quadra : quadras) {
            nomesQuadras.add(quadra.getNome());
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1, nomesQuadras);
        listView.setAdapter(adapter);

        FloatingActionButton fab = binding.floatingActionButtonQuadrasLocador;
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), QuadrasActivity.class);
                intent.putExtra("userId", userId);
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
