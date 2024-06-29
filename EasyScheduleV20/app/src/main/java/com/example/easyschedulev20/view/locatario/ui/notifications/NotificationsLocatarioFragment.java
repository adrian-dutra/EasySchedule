package com.example.easyschedulev20.view.locatario.ui.notifications;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.easyschedulev20.R;
import com.example.easyschedulev20.databinding.FragmentNotificationsLocatarioBinding;
import com.example.easyschedulev20.model.Notificacao;
import com.example.easyschedulev20.model.QuadraEsportiva;
import com.example.easyschedulev20.model.Repository.NotificacaoRepository;

import java.util.ArrayList;
import java.util.List;

public class NotificationsLocatarioFragment extends Fragment {

    private FragmentNotificationsLocatarioBinding binding;
    private NotificacaoRepository notificacaoRepository;
    private NotificationsLocatarioViewModel notificationsLocatarioViewModel;
    private ArrayAdapter<String> adapter;
    private int userId;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            userId = getArguments().getInt("userId", 0);
        }
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentNotificationsLocatarioBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        notificacaoRepository = new NotificacaoRepository(requireActivity().getApplication());

        ListView listView = binding.listNotificaLoacatario;
        adapter = new ArrayAdapter<>(requireContext(), android.R.layout.simple_list_item_1);
        listView.setAdapter(adapter);

        notificationsLocatarioViewModel = new ViewModelProvider(this).get(NotificationsLocatarioViewModel.class);

        new FetchNotificationsTask().execute(userId);

//        List<Notificacao> notificacaos = NotificationsLocatarioViewModel.getAllNotificacoesByUserId(requireActivity().getApplication(), userId);
//        List<String> message = new ArrayList<>();
//        for(Notificacao notificacao : notificacaos){
//            message.add(notificacao.getMessage());
//        }

//        notificacaoRepository.getAllNotificacoesByUserId(userId).set(getViewLifecycleOwner(), new Observer<List<Notificacao>>() {
//            @Override
//            public void onChanged(List<Notificacao> notificacoes) {
//                adapter.clear();
//                for (Notificacao notificacao : notificacoes) {
//                    adapter.add(notificacao.getTitle() + ": " + notificacao.getMessage());
//                }
//                adapter.notifyDataSetChanged();
//            }
//        });

        return root;
    }

    private class FetchNotificationsTask extends AsyncTask<Integer, Void, List<Notificacao>> {
        @Override
        protected List<Notificacao> doInBackground(Integer... params) {
            return notificationsLocatarioViewModel.getAllNotificacoesByUserId(requireActivity().getApplication(), params[0]);
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