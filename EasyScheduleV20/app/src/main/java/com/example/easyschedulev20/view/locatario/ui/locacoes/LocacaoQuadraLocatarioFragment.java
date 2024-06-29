package com.example.easyschedulev20.view.locatario.ui.locacoes;

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
import com.example.easyschedulev20.databinding.FragmentLocacaoQuadraLocatarioBinding;
import com.example.easyschedulev20.model.LocacaoQuadra;
import com.example.easyschedulev20.model.QuadraEsportiva;

import java.util.ArrayList;
import java.util.List;


public class LocacaoQuadraLocatarioFragment extends Fragment {

    private FragmentLocacaoQuadraLocatarioBinding binding;
    private LocacaoQuadraLocatarioViewModel locacaoQuadraLocatarioViewModel;
    private ListView listView_locacoes_locatario;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        LocacaoQuadraLocatarioViewModel locacaoQuadraLocatarioViewModel =
                new ViewModelProvider(this).get(LocacaoQuadraLocatarioViewModel.class);

        binding = FragmentLocacaoQuadraLocatarioBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        locacaoQuadraLocatarioViewModel = new LocacaoQuadraLocatarioViewModel();
        listView_locacoes_locatario = root.findViewById(R.id.listView_locacoes_locatario);

        List<LocacaoQuadra>locacoes = locacaoQuadraLocatarioViewModel.listarLocacoes(requireActivity().getApplication());
        List<String> nomesQuadras = new ArrayList<>();
        for (LocacaoQuadra locacao : locacoes) {
            nomesQuadras.add(locacao.getHoraInicio());
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1, nomesQuadras);
        listView_locacoes_locatario.setAdapter(adapter);

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}