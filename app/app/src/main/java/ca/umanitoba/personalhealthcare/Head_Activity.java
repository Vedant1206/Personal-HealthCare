package ca.umanitoba.personalhealthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Head_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_head);
    }

    public void clickHeadache(View v){
        Intent i = new Intent(this, Headache_Activity.class);
        startActivity(i);
    }

    public void clickCongestion(View v){
        Intent i = new Intent(this, Cold_Activity.class);
        startActivity(i);
    }

}