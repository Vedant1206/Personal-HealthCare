package ca.umanitoba.personalhealthcare.presentation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import ca.umanitoba.personalhealthcare.R;
import ca.umanitoba.personalhealthcare.presentation.NauseaActivity;

public class StomachActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stomach);
    }

    public void clickNausea(View v){
        Intent i = new Intent(this, NauseaActivity.class);
        startActivity(i);
    }

}