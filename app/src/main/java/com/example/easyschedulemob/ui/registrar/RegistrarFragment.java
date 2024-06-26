package com.example.easyschedulemob.ui.registrar;



import com.example.easyschedulemob.MainActivity;
import com.example.easyschedulemob.R;
import com.example.easyschedulemob.core.Util;
import com.example.easyschedulemob.model.Usuario;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link RegistrarFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RegistrarFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;
    private EditText editTextPassword;
    private EditText editTextEmail;
    private EditText editTextName;
    private TextView textViewCPF;
    private EditText editTextCPF;
    private TextView textViewCNPJ;
    private EditText editTextCNPJ;
    private Usuario usuario;
    private Spinner spinnerTipoUsuario;

    public RegistrarFragment() {
    }

    public static RegistrarFragment newInstance(String param1, String param2) {
        RegistrarFragment fragment = new RegistrarFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_registrar, container, false);

        editTextPassword = view.findViewById(R.id.editTextPassword);
        editTextEmail = view.findViewById(R.id.editTextEmail);
        editTextName = view.findViewById(R.id.editTextName);
        textViewCPF = view.findViewById(R.id.textViewCPF);
        editTextCPF = view.findViewById(R.id.editTextCPF);
        textViewCNPJ = view.findViewById(R.id.textViewCNPJ);
        editTextCNPJ = view.findViewById(R.id.editTextCNPJ);

        Button buttonRegister = view.findViewById(R.id.buttonRegister);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getContext(),
                R.array.user_types, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerTipoUsuario.setAdapter(adapter);

        spinnerTipoUsuario.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = parent.getItemAtPosition(position).toString();
                if (selectedItem.equals("Locatário")) {
                    textViewCPF.setVisibility(View.VISIBLE);
                    editTextCPF.setVisibility(View.VISIBLE);
                    textViewCNPJ.setVisibility(View.GONE);
                    editTextCNPJ.setVisibility(View.GONE);
                } else if (selectedItem.equals("Locador")) {
                    textViewCPF.setVisibility(View.GONE);
                    editTextCPF.setVisibility(View.GONE);
                    textViewCNPJ.setVisibility(View.VISIBLE);
                    editTextCNPJ.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }

            RegistrarViewModel registrarViewModel = new ViewModelProvider(this).get(RegistrarViewModel.class);
        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String password = editTextPassword.getText().toString();
                String email = editTextEmail.getText().toString();
                String nome = editTextName.getText().toString();

                ArrayList<Object> infoList = new ArrayList<>();
                infoList.add(password);
                infoList.add(email);
                infoList.add(nome);

                Util util = new Util();

                if (util.validateInfo(infoList)) {
                    if(util.validateEmail(email) ){
                        usuario = new Usuario(nome, email, password);
                        registrarViewModel.registrarUsuario(usuario, requireActivity().getApplication());
                        Toast.makeText(getActivity(), "Usuario registrado com sucesso !", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getActivity(), MainActivity.class);
                        startActivity(intent);
                    }else{
                        Toast.makeText(getActivity(), "O email está com um formato incorreto, por favor insira um email válido.", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(getActivity(), "Por favor, preencha todos os campos.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        return view;
    }
}
