package ca.umanitoba.personalhealthcare.presentation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

import ca.umanitoba.personalhealthcare.R;

public class CreateAccountActivity extends AppCompatActivity {

    ArrayList<String> emails = new ArrayList<String>();
    ArrayList<String> passwords = new ArrayList<String>();
    int index = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);
    }

    public void enter(View v){
        TextView email = findViewById(R.id.email);
        TextView password = findViewById(R.id.pass);
        String em = email.getText().toString();
        String pass = password.getText().toString();
        Log.d("email", em);
        Log.d("password",pass);

    }
}