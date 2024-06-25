package com.example.easyschedulemob.ui.home.locador.menus.notifications;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.easyschedulemob.databinding.FragmentNotificationsLocadorBinding;

public class LocadorNotificationsFragment extends Fragment {

    private FragmentNotificationsLocadorBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        LocadorNotificationsViewModel notificationsViewModel =
                new ViewModelProvider(this).get(LocadorNotificationsViewModel.class);

        binding = FragmentNotificationsLocadorBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textNotifications;
        notificationsViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}