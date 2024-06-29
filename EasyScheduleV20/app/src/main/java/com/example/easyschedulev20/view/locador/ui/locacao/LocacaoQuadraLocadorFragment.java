package com.example.easyschedulev20.view.locador.ui.locacao;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.easyschedulev20.R;
import com.example.easyschedulev20.databinding.FragmentLocacaoQuadraLocadorBinding;
import com.example.easyschedulev20.model.LocacaoQuadra;

import java.util.ArrayList;
import java.util.List;


public class LocacaoQuadraLocadorFragment extends Fragment {

    private FragmentLocacaoQuadraLocadorBinding binding;
    private ListView listView_quadras_locador;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        LocacaoQuadraLocadorViewModel locacaoQuadraLocadorViewModel =
                new ViewModelProvider(this).get(LocacaoQuadraLocadorViewModel.class);

        binding = FragmentLocacaoQuadraLocadorBinding.inflate(inflater, container, false);
        View root = binding.getRoot();


        listView_quadras_locador = root.findViewById(R.id.listView_quadras_locador);
        List<LocacaoQuadra> locacoes = locacaoQuadraLocadorViewModel.listarLocacoes(requireActivity().getApplication());
        List<String> nomesQuadras = new ArrayList<>();
        for (LocacaoQuadra locacao : locacoes) {
            nomesQuadras.add(locacao.getHoraInicio());
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1, nomesQuadras);
        listView_quadras_locador.setAdapter(adapter);

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}