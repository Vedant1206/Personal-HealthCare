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
        Intent i = new Intent(this, CreateAccountActivity.class);
        startActivity(i);
    }

    public void openLogIn(View view) {
        Intent i = new Intent(this, LogInActivity.class);
        startActivity(i);
    }

    public void openGuestMode (View view) {
        //TODO: move on to next mode as guest
        System.out.println("Move on to next page as guest");

    }
}