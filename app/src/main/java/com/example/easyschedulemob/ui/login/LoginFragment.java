package com.example.easyschedulemob.ui.login;

import android.os.Bundle;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.easyschedulemob.R;
import com.example.easyschedulemob.core.Util;
import com.example.easyschedulemob.databinding.FragmentLoginBinding;

import java.util.ArrayList;
import java.util.Objects;

import com.example.easyschedulemob.model.Usuario;
import com.example.easyschedulemob.ui.home.locador.LocadorActivity;
import com.example.easyschedulemob.ui.home.locatario.LocatarioActivity;

public class LoginFragment extends Fragment {

    private FragmentLoginBinding binding;
    private Button btn_login;
    private LoginViewModel vmLogin;
    private EditText edtxt_Password;
    private EditText edtxt_Username;

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_login, container, false);
        vmLogin = new ViewModelProvider(this, new ViewModelProvider.AndroidViewModelFactory(getActivity().getApplication())).get(LoginViewModel.class);

        binding = FragmentLoginBinding.inflate(inflater, container, false);
        edtxt_Password = view.findViewById(R.id.edtxt_Password);
        edtxt_Username = view.findViewById(R.id.edtxt_Username);
        btn_login = view.findViewById(R.id.btn_login);

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email = edtxt_Username.getText().toString();
                String password = edtxt_Password.getText().toString();

                ArrayList<Object> infoList = new ArrayList<>();
                infoList.add(password);
                infoList.add(email);

                Util util = new Util();
                if (util.validateInfo(infoList)) {
                    if(util.validateEmail(email) ){
                        vmLogin.listarUsuarioPeloEmail(email);
                    } else {
                        Toast.makeText(getActivity(), "O email está com um formato incorreto, por favor insira um email válido.", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(getActivity(), "Por favor, preencha todos os campos.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        vmLogin.getUsuarioLiveData().observe(getViewLifecycleOwner(), new Observer<Usuario>() {
            @Override
            public void onChanged(Usuario usuario) {
                String password = edtxt_Password.getText().toString();
                if(usuario != null && Objects.equals(usuario.getEmail(), edtxt_Username.getText().toString()) && Objects.equals(usuario.getPassword(), password)) {
                    Toast.makeText(getActivity(), "Login realizado com sucesso !", Toast.LENGTH_SHORT).show();

                    Intent intent;
                    if (Objects.equals(usuario.getTipoUsuario(), "locatário")) {
                        intent = new Intent(getActivity(), LocatarioActivity.class);
                        intent.putExtra("locatarioId", usuario.getUserId());
                    } else {
                        intent = new Intent(getActivity(), LocadorActivity.class);
                    }
                    startActivity(intent);
                    requireActivity().finish();
                } else {
                    Toast.makeText(getActivity(), "As credenciais estão incorretas", Toast.LENGTH_SHORT).show();
                }
            }
        });

        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}