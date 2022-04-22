package ca.umanitoba.personalhealthcare.application;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import ca.umanitoba.personalhealthcare.R;
import ca.umanitoba.personalhealthcare.business.SessionManager;
import ca.umanitoba.personalhealthcare.business.SessionManagerImp;
import ca.umanitoba.personalhealthcare.objects.LoginSession;
import ca.umanitoba.personalhealthcare.presentation.CreateAccountActivity;
import ca.umanitoba.personalhealthcare.presentation.LogInActivity;
import ca.umanitoba.personalhealthcare.presentation.SearchActivity;

public class MainActivity extends AppCompatActivity {

    Button loginButton;
    Button createAccountButton;
    Button selectProfileButton;
    Button logoutButton;
    TextView welcomeTextView;

    SessionManager sessionManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sessionManager = new SessionManagerImp();

        loginButton = (Button) findViewById(R.id.openLoginBtn);
        createAccountButton = (Button) findViewById(R.id.main_create_account_btn);
        welcomeTextView = (TextView) findViewById(R.id.main_welcome);
        selectProfileButton = (Button) findViewById(R.id.main_select_profile_btn);
        logoutButton = (Button) findViewById(R.id.main_log_out_btn);

        loginButton.setOnClickListener(view -> {
            openLoginActivity(view);
        });

        logoutButton.setOnClickListener(view -> {
            logout();
        });

        selectProfileButton.setOnClickListener(view -> {
            //TODO: update profile selection when we have select profile features
        });

        updateView();
    }

    private void updateView () {
        loginButton.setVisibility(View.GONE);
        createAccountButton.setVisibility(View.GONE);
        selectProfileButton.setVisibility(View.GONE);
        logoutButton.setVisibility(View.GONE);

        handleIsLogin(sessionManager.retrieveSession());
    }

    private void logout () {
        sessionManager.logout();
        updateView();
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

    private void handleIsLogin (LoginSession session) {
        if (session.isLogined()) {
            welcomeTextView.setText("Welcome user " + session.getMemberEmail());
            selectProfileButton.setVisibility(View.VISIBLE);
            logoutButton.setVisibility(View.VISIBLE);

        } else {
            welcomeTextView.setText(R.string.main_welcome_default);
            loginButton.setVisibility(View.VISIBLE);
            createAccountButton.setVisibility(View.VISIBLE);

        }
    }
}