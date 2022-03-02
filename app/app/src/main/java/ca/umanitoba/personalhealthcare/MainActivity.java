package ca.umanitoba.personalhealthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void createAccount(View view){
        Intent i = new Intent(this, Create_Account.class);
        startActivity(i);
    }
    public void searchSymptom(View v){
        Intent i = new Intent(this, SearchActivity.class);
        startActivity(i);
    }
}