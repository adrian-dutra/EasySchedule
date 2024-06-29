package com.example.easyschedulev20.view.locador.ui.notifications;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.easyschedulev20.databinding.FragmentNotificationsLocadorBinding;
import com.example.easyschedulev20.model.Notificacao;
import com.example.easyschedulev20.model.Repository.NotificacaoRepository;

import java.util.ArrayList;
import java.util.List;

public class NotificationsLocadorFragment extends Fragment {

    private FragmentNotificationsLocadorBinding binding;
    private NotificacaoRepository notificacaoRepository;
    private NotificationsLocadorViewModel notificationsLocadorViewModel;
    private ArrayAdapter<String> adapter;
    private int userId;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            userId = getArguments().getInt("userId", 0);
        }
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

//        com.example.easyschedulev20.view.locador.ui.notifications.NotificationsLocadorViewModel notificationsLocadorViewModel =
//                new ViewModelProvider(this).get(com.example.easyschedulev20.view.locador.ui.notifications.NotificationsLocadorViewModel.class);

        binding = FragmentNotificationsLocadorBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        notificacaoRepository = new NotificacaoRepository(requireActivity().getApplication());

        ListView listView = binding.listNotificaLocador;
        adapter = new ArrayAdapter<>(requireContext(), android.R.layout.simple_list_item_1);
        listView.setAdapter(adapter);

        notificationsLocadorViewModel = new ViewModelProvider(this).get(NotificationsLocadorViewModel.class);

        new FetchNotificationsTask().execute(userId);

        //final TextView textView = binding.textNotifications;
        //notificationsLocadorViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    private class FetchNotificationsTask extends AsyncTask<Integer, Void, List<Notificacao>> {
        @Override
        protected List<Notificacao> doInBackground(Integer... params) {
            return notificationsLocadorViewModel.getAllNotificacoesByUserId(requireActivity().getApplication(), params[0]);
        }

        @Override
        protected void onPostExecute(List<Notificacao> notificacoes) {
            adapter.clear();
            List<String> messages = new ArrayList<>();
            for (Notificacao notificacao : notificacoes) {
                messages.add(notificacao.getTitle() + ": " + notificacao.getMessage());
            }
            adapter.addAll(messages);
            adapter.notifyDataSetChanged();
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}