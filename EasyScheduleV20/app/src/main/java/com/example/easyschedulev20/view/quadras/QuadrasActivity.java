package com.example.easyschedulev20.view.quadras;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.example.easyschedulev20.R;

public class QuadrasActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quadras);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, QuadrasFragment.newInstance())
                    .commitNow();
        }
    }
}
