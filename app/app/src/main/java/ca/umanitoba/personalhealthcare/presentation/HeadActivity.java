package ca.umanitoba.personalhealthcare.presentation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import ca.umanitoba.personalhealthcare.R;
import ca.umanitoba.personalhealthcare.presentation.ColdActivity;
import ca.umanitoba.personalhealthcare.presentation.HeadacheActivity;

public class HeadActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_head);
    }

    public void clickHeadache(View v){
        Intent i = new Intent(this, HeadacheActivity.class);
        startActivity(i);
    }

    public void clickCongestion(View v){
        Intent i = new Intent(this, ColdActivity.class);
        startActivity(i);
    }

}