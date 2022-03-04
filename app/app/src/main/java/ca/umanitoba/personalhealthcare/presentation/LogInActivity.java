package ca.umanitoba.personalhealthcare.presentation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import ca.umanitoba.personalhealthcare.R;

public class LogInActivity extends AppCompatActivity {

    EditText username;
    EditText password;
    AppCompatButton loginBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        loginBtn = (AppCompatButton) findViewById(R.id.loginBtn);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (login(view)) {
                    succeedLogin();
                } else {
                    failLogin();
                }
            }
        });

    }

    public void succeedLogin() {
        //TODO: alert user the login succeed and move on to next screen
    }

    public void failLogin() {
        //TODO: alert user the login fail
    }


    public boolean login(View view) {
        String usernameText = username.getText().toString();
        String password = username.getText().toString();

        //TODO: check if username and password match any account here
        System.out.println("We are checking authentication...");

        return false;
    }


}