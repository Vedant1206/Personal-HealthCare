package ca.umanitoba.personalhealthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import ca.umanitoba.personalhealthcare.presentation.CreateAccountActivity;
import ca.umanitoba.personalhealthcare.presentation.LogInActivity;
import ca.umanitoba.personalhealthcare.presentation.SearchActivity;

public class MainActivity extends AppCompatActivity {

    Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loginButton = (Button) findViewById(R.id.openLoginBtn);
    }

    public void createAccount(View view){
        Intent i = new Intent(this, CreateAccountActivity.class);
        startActivity(i);
    }
    public void searchSymptom(View v){
        Intent i = new Intent(this, SearchActivity.class);
        startActivity(i);
    }

    public void openLoginActivity (View view) {
        Intent i = new Intent( this, LogInActivity.class);
        startActivity(i);
    }
}