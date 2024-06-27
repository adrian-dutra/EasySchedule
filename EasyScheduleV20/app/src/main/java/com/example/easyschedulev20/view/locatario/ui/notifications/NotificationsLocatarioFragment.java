package com.example.easyschedulev20.view.locatario.ui.notifications;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.easyschedulev20.databinding.FragmentNotificationsLocatarioBinding;


public class NotificationsLocatarioFragment extends Fragment {

    private FragmentNotificationsLocatarioBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        com.example.easyschedule.view.locatario.ui.notifications.NotificationsLocatarioViewModel notificationsLocatarioViewModel =
                new ViewModelProvider(this).get(com.example.easyschedule.view.locatario.ui.notifications.NotificationsLocatarioViewModel.class);

        binding = FragmentNotificationsLocatarioBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textNotifications;
        notificationsLocatarioViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}