package com.example.easyschedulev20.view.LocacaoQuadra;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.easyschedulev20.R;
import com.example.easyschedulev20.model.LocacaoQuadra;
import com.example.easyschedulev20.model.QuadraEsportiva;

import java.time.LocalDate;

public class LocacaoQuadraFragment extends Fragment {

    private QuadraEsportiva quadraSelecionada;
    private Button button_registrar_locacao;
    private LocacaoQuadra locacaoQuadra;
    private EditText editTextHoraIni;
    private EditText editTextHoraFim;
    private LocacaoQuadraViewModel locacaoQuadraViewModel;


    public static LocacaoQuadraFragment newInstance() {
        return new LocacaoQuadraFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            quadraSelecionada = (QuadraEsportiva) getArguments().getSerializable("quadraSelecionada");
        }
        locacaoQuadraViewModel = new LocacaoQuadraViewModel();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_locacao_quadra, container, false);

        if (getArguments() != null) {
            quadraSelecionada = (QuadraEsportiva) getArguments().getSerializable("quadraSelecionada");
        }

        // Inicialização do botão e EditTexts
        button_registrar_locacao = root.findViewById(R.id.button_registrar_locacao);
        editTextHoraIni = root.findViewById(R.id.editText_hora_ini);
        editTextHoraFim = root.findViewById(R.id.editText_hora_fim);

        int quadraId = 0;
        int userId = 0;

        if (quadraSelecionada != null) {
            quadraId = quadraSelecionada.getQuadraEsportivaId();
            userId = quadraSelecionada.getUserId();
        }

        Log.d("Warning", "Quadra id !!!!!!!!!!!!!!!!! + " + quadraId);
        Log.d("Warning", "Quadra id !!!!!!!!!!!!!!!!! + " + userId);

        int finalQuadraId = quadraId;
        int finalUserId = userId;
        button_registrar_locacao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String horaInicio = editTextHoraIni.getText().toString().trim();
                String horaFim = editTextHoraFim.getText().toString().trim();


                locacaoQuadra = new LocacaoQuadra(finalQuadraId, finalUserId, horaInicio, horaFim);
                locacaoQuadraViewModel.inserirLocacao(locacaoQuadra, requireActivity().getApplication());
            }
        });

        return root;
    }
}
