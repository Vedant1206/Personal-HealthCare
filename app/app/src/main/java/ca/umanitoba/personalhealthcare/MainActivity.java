package ca.umanitoba.personalhealthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loginButton = (Button) findViewById(R.id.openLoginBtn);
    }

    public void createAccount(View view){
        Intent i = new Intent(this, Create_Account.class);
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