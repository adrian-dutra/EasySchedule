package com.example.easyschedulev20.view.quadras;

import androidx.lifecycle.ViewModelProvider;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.easyschedulev20.R;
import com.example.easyschedulev20.core.Util;
import com.example.easyschedulev20.model.QuadraEsportiva;

import java.util.ArrayList;

public class QuadrasFragment extends Fragment {

    private QuadrasViewModel mViewModel;
    private Spinner statusSpinner;
    private Button button_save_quadra;
    private EditText editText_nome_quadra;
    private EditText editText_tipo_quadra;
    private EditText editText_preco_quadra;
    private int userId;
    private QuadrasViewModel quadrasViewModel;

    public static QuadrasFragment newInstance() {
        return new QuadrasFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        quadrasViewModel = new QuadrasViewModel();
        return inflater.inflate(R.layout.fragment_quadras, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(QuadrasViewModel.class);

        // Inicializar os componentes da UI
        statusSpinner = getView().findViewById(R.id.spinner_status_quadra);
        button_save_quadra = getView().findViewById(R.id.button_save_quadra);
        editText_nome_quadra = getView().findViewById(R.id.editText_nome_quadra);
        editText_tipo_quadra = getView().findViewById(R.id.editText_tipo_quadra);
        editText_preco_quadra = getView().findViewById(R.id.editText_preco_quadra);

        // Definir as opções do spinner
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getContext(),
                R.array.status_options, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        statusSpinner.setAdapter(adapter);

        // Configurar o OnClickListener para o botão de salvar
        button_save_quadra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Capturar os valores inseridos nos campos
                String nome = editText_nome_quadra.getText().toString();
                String tipo = editText_tipo_quadra.getText().toString();
                String precoStr = editText_preco_quadra.getText().toString();
                double preco = Double.parseDouble(precoStr);
                int status = statusSpinner.getSelectedItem().toString().equals("ativo") ? 1: 0;
                if (getArguments() != null) {
                    userId = getArguments().getInt("userId", 0);
                }
                ArrayList<Object> infoList = new ArrayList<>();
                infoList.add(nome);
                infoList.add(tipo);
                infoList.add(preco);
                infoList.add(status);
                infoList.add(userId);

                Util util = new Util();

                if(util.validateInfo(infoList)){

                    QuadraEsportiva quadra = new QuadraEsportiva(nome, tipo, preco, status, userId);
                    quadrasViewModel.registrarQuadra(quadra, requireActivity().getApplication());

                }else{
                    Toast.makeText(getActivity(), "Por favor, preencha todos os campos.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
