package com.example.easyschedule.ui.home.locatario.menus.notifications;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.easyschedulemob.databinding.FragmentNotificationsBinding;

public class NotificationsLocatarioFragment extends Fragment {

    private com.example.easyschedulemob.databinding.FragmentNotificationsLocatarioBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        NotificationsLocatarioViewModel notificationsLocatarioViewModel =
                new ViewModelProvider(this).get(NotificationsLocatarioViewModel.class);

        binding = com.example.easyschedulemob.databinding.FragmentNotificationsLocatarioBinding.inflate(inflater, container, false);
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