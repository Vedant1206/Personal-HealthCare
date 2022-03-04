package ca.umanitoba.personalhealthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Stomach_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stomach);
    }

    public void clickNausea(View v){
        Intent i = new Intent(this, Nausea_Activity.class);
        startActivity(i);
    }

}