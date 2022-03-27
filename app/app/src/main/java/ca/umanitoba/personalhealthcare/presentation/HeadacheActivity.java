package ca.umanitoba.personalhealthcare.presentation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import ca.umanitoba.personalhealthcare.R;

public class HeadacheActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_headache);
        TextView t = findViewById(R.id.headacheTextView);
        Bundle b = getIntent().getExtras();
        String data = b.getString("description");
        System.out.println(data);
        t.setText(data);
    }
}
