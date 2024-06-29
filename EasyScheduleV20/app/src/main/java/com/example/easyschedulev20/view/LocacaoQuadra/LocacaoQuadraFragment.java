package com.example.easyschedulev20.view.LocacaoQuadra;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.easyschedulev20.R;
import com.example.easyschedulev20.model.QuadraEsportiva;

public class LocacaoQuadraFragment extends Fragment {

    private QuadraEsportiva quadraSelecionada;

    public static LocacaoQuadraFragment newInstance() {
        return new LocacaoQuadraFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            quadraSelecionada = (QuadraEsportiva) getArguments().getSerializable("quadraSelecionada");
        }
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_locacao_quadra, container, false);

        if (quadraSelecionada != null) {
            int quadraId = quadraSelecionada.getQuadraEsportivaId();
            int userId = quadraSelecionada.getUserId();
            
        }

        return root;
    }
}
