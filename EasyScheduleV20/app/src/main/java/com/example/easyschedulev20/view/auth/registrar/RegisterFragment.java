package com.example.easyschedulev20.view.auth.registrar;

import android.content.Intent;
import android.os.Bundle;
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

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.easyschedulev20.MainActivity;
import com.example.easyschedulev20.R;
import com.example.easyschedulev20.core.Util;
import com.example.easyschedulev20.model.Usuario;

import java.util.ArrayList;

public class RegisterFragment extends Fragment {

    private EditText editTextPassword;
    private EditText editTextEmail;
    private EditText editTextName;
    private Spinner spinner_tipoUsuario;
    private EditText editTextCPF;
    private EditText editTextCNPJ;
    private TextView textViewCPF;
    private TextView textViewCNPJ;
    private Usuario usuario;

    public RegisterFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_register, container, false);

        editTextPassword = view.findViewById(R.id.editTextPassword);
        editTextEmail = view.findViewById(R.id.editTextEmail);
        editTextName = view.findViewById(R.id.editTextName);
        spinner_tipoUsuario = view.findViewById(R.id.spinner_tipoUsuario);
        editTextCPF = view.findViewById(R.id.editTextCPF);
        editTextCNPJ = view.findViewById(R.id.editTextCNPJ);
        textViewCPF = view.findViewById(R.id.textViewCPF);
        textViewCNPJ = view.findViewById(R.id.textViewCNPJ);
        Button buttonRegister = view.findViewById(R.id.buttonRegister);

        // Inicializar o Spinner
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity(),
                R.array.tipo_usuario_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_tipoUsuario.setAdapter(adapter);

        // Adicionar o listener ao Spinner
        spinner_tipoUsuario.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = parent.getItemAtPosition(position).toString();
                if (selectedItem.equals("Locador")) {
                    textViewCNPJ.setVisibility(View.VISIBLE);
                    editTextCNPJ.setVisibility(View.VISIBLE);
                    textViewCPF.setVisibility(View.GONE);
                    editTextCPF.setVisibility(View.GONE);
                } else if (selectedItem.equals("Locatário")) {
                    textViewCNPJ.setVisibility(View.GONE);
                    editTextCNPJ.setVisibility(View.GONE);
                    textViewCPF.setVisibility(View.VISIBLE);
                    editTextCPF.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Do nothing
            }
        });

        RegisterViewModel registrarViewModel = new ViewModelProvider(this).get(RegisterViewModel.class);

        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String password = editTextPassword.getText().toString();
                String email = editTextEmail.getText().toString();
                String nome = editTextName.getText().toString();
                String tipoUsuario = spinner_tipoUsuario.getSelectedItem().toString();
                String cpf = editTextCPF.getText().toString();
                String cnpj = editTextCNPJ.getText().toString();

                ArrayList<Object> infoList = new ArrayList<>();
                infoList.add(password);
                infoList.add(email);
                infoList.add(nome);
                infoList.add(tipoUsuario);
                if (tipoUsuario.equals("Locador")) {
                    infoList.add(cnpj);
                } else if (tipoUsuario.equals("Locatário")) {
                    infoList.add(cpf);
                }

                Util util = new Util();

                if (util.validateInfo(infoList)) {
                    if (util.validateEmail(email)) {

                        usuario = new Usuario(nome, email, password, tipoUsuario, cpf, cnpj);
                        registrarViewModel.registrarUsuario(usuario, requireActivity().getApplication());
                        Toast.makeText(getActivity(), "Usuario registrado com sucesso !", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getActivity(), MainActivity.class);
                        startActivity(intent);
                    } else {
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
