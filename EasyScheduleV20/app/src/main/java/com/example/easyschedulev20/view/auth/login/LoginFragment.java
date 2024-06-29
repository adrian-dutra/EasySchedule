package com.example.easyschedulev20.view.auth.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.util.Log;


import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;


import com.example.easyschedulev20.R;
import com.example.easyschedulev20.core.Util;
import com.example.easyschedulev20.databinding.FragmentLoginBinding;
import com.example.easyschedulev20.model.Usuario;
import com.example.easyschedulev20.view.auth.login.LoginViewModel;
import com.example.easyschedulev20.view.locador.LocadorActivity;
import com.example.easyschedulev20.view.locatario.LocatarioActivity;
import com.google.android.ads.mediationtestsuite.activities.HomeActivity;

import java.util.ArrayList;
import java.util.Objects;


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
        vmLogin = new ViewModelProvider(this).get(LoginViewModel.class);

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
                Usuario usuario;

                if (util.validateInfo(infoList)) {
                    if(util.validateEmail(email)) {
                        usuario = vmLogin.listarUsuarioPeloEmail(email, requireActivity().getApplication());

                        if (usuario != null && Objects.equals(usuario.getEmail(), email) && Objects.equals(usuario.getPassword(), password)) {
                            Toast.makeText(getActivity(), "Login realizado com sucesso!", Toast.LENGTH_SHORT).show();

                            Intent intent;
                            if ("Locador".equals(usuario.getTipoUsuario())) {
                                intent = new Intent(getActivity(), LocadorActivity.class);
                            } else if ("Locatário".equals(usuario.getTipoUsuario())) {
                                intent = new Intent(getActivity(), LocatarioActivity.class);
                            } else {
                                Toast.makeText(getActivity(), "Tipo de usuário desconhecido.", Toast.LENGTH_SHORT).show();
                                return;
                            }
                            intent.putExtra("usuarioId", usuario.getUserId());
                            startActivity(intent);
                            requireActivity().finish();
                        } else {
                            Toast.makeText(getActivity(), "As credenciais estão incorretas", Toast.LENGTH_SHORT).show();
                        }

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

    /*public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.edtxtPassword.setOnClickListener(v ->
                NavHostFragment.findNavController(LoginFragment.this)
                        .navigate(R.id.action_SecondFragment_to_FirstFragment)
        );
    }*/

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}