package com.example.easyschedulev20.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import com.example.easyschedulev20.R;

public class HomeFragment extends Fragment {

    private Button bt_login;
    private Button bt_register;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        bt_login = view.findViewById(R.id.bt_login);
        bt_register = view.findViewById(R.id.bt_register);

        NavController navController = NavHostFragment.findNavController(this);

        bt_login.setOnClickListener(v -> navController.navigate(R.id.action_home_to_login));
        bt_register.setOnClickListener(v -> navController.navigate(R.id.action_home_to_register));

        return view;
    }
}
