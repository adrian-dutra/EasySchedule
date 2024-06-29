package com.example.easyschedulev20.view.quadras;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.example.easyschedulev20.R;

public class QuadrasActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quadras);

        int userId = getIntent().getIntExtra("userId", 0);

        QuadrasFragment quadrasFragment = QuadrasFragment.newInstance();
        Bundle bundle = new Bundle();
        bundle.putInt("userId", userId);
        quadrasFragment.setArguments(bundle);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, quadrasFragment)
                .commit();
    }

}
