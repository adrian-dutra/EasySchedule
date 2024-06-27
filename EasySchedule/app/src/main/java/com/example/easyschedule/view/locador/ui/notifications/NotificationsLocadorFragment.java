package com.example.easyschedule.view.locador.ui.notifications;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.easyschedule.databinding.FragmentNotificationsLocadorBinding;

public class NotificationsLocadorFragment extends Fragment {

    private FragmentNotificationsLocadorBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        NotificationsLocadorViewModel notificationsLocadorViewModel =
                new ViewModelProvider(this).get(NotificationsLocadorViewModel.class);

        binding = FragmentNotificationsLocadorBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textNotifications;
        notificationsLocadorViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}