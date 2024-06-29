package com.example.easyschedulev20.view.LocacaoQuadra;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.example.easyschedulev20.R;
import com.example.easyschedulev20.model.QuadraEsportiva;

public class LocacaoQuadraActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_locacao_quadra);

        QuadraEsportiva quadra = (QuadraEsportiva) getIntent().getSerializableExtra("quadraSelecionada");

        LocacaoQuadraFragment locacaoQuadraFragment = LocacaoQuadraFragment.newInstance();
        Bundle bundle = new Bundle();
        bundle.putSerializable("quadraSelecionada", quadra);
        locacaoQuadraFragment.setArguments(bundle);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container_locacao, locacaoQuadraFragment)
                .commit();
    }
}
