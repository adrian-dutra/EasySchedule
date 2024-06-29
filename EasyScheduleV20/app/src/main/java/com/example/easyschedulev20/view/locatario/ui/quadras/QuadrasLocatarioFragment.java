package com.example.easyschedulev20.view.locatario.ui.quadras;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.easyschedulev20.databinding.FragmentQuadrasLocatarioBinding;
import com.example.easyschedulev20.model.QuadraEsportiva;
import com.example.easyschedulev20.view.LocacaoQuadra.LocacaoQuadraActivity;
import com.example.easyschedulev20.view.LocacaoQuadra.LocacaoQuadraFragment;
import com.example.easyschedulev20.view.quadras.QuadrasActivity;

import java.util.ArrayList;
import java.util.List;


public class QuadrasLocatarioFragment extends Fragment {

    private FragmentQuadrasLocatarioBinding binding;
    private ListView listView_locacoes_locatario;
    private int userId;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        QuadrasLocatarioViewModel quadrasLocatarioViewModel =
                new ViewModelProvider(this).get(QuadrasLocatarioViewModel.class);

        binding = FragmentQuadrasLocatarioBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        listView_locacoes_locatario = binding.listViewQuadrasLocatario;

        if (getArguments() != null) {
            userId = getArguments().getInt("userId", 0);
        }

        Log.i("WARNIGN", "LOCATAAAAAAARIOOOOOO2: " + userId);

        List<QuadraEsportiva> quadras = quadrasLocatarioViewModel.listarQuadras(requireActivity().getApplication());
        List<String> nomesQuadras = new ArrayList<>();
        for (QuadraEsportiva quadra : quadras) {
            nomesQuadras.add(quadra.getNome());
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1, nomesQuadras);
        listView_locacoes_locatario.setAdapter(adapter);

        // Configurar o onItemClick para passar o objeto QuadraEsportiva
        listView_locacoes_locatario.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                QuadraEsportiva quadraSelecionada = quadras.get(position);
                Intent intent = new Intent(getActivity(), LocacaoQuadraActivity.class);
                intent.putExtra("quadraSelecionada", quadraSelecionada);
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
