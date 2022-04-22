package ca.umanitoba.personalhealthcare.presentation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.se.omapi.Session;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import ca.umanitoba.personalhealthcare.R;
import ca.umanitoba.personalhealthcare.application.MainActivity;
import ca.umanitoba.personalhealthcare.business.AccountManager;
import ca.umanitoba.personalhealthcare.business.AccountManagerImp;
import ca.umanitoba.personalhealthcare.business.SessionManager;
import ca.umanitoba.personalhealthcare.business.SessionManagerImp;
import ca.umanitoba.personalhealthcare.objects.LoginSession;
import ca.umanitoba.personalhealthcare.persistence.LoginSessionPersistenceImp;

public class LogInActivity extends AppCompatActivity {

    private EditText username;
    private EditText password;
    private AppCompatButton loginBtn;
    private TextView feedbackTextView;

    private AccountManager accountManager;
    private SessionManager sessionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        loginBtn = (AppCompatButton) findViewById(R.id.loginBtn);

        feedbackTextView = (TextView) findViewById(R.id.login_feedback);
        feedbackTextView.setVisibility(View.GONE);
        accountManager = new AccountManagerImp();
        sessionManager = new SessionManagerImp();


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

        LoginSession session = sessionManager.retrieveSession();
        isLoginRemembered(session);

    }

    void feedbackException(String message, int color) {
        feedbackTextView.setText(message);
        feedbackTextView.setVisibility(View.VISIBLE);
        feedbackTextView.setTextColor(color);
    }
    private void isLoginRemembered (LoginSession session) {
        if (session.isLogined()) {
            backToMainActivity();
        } else if (session.getMemberEmail() != null) {
            username.setText(session.getMemberEmail());
        }
    }

    private void backToMainActivity () {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void succeedLogin() {
        feedbackException("Login succeeded!", Color.GREEN);
        moveToProfileActivity();
    }

    public void failLogin() {
        feedbackException("Email or password is wrong. Please try again!", Color.RED);
        password.setText("");
    }

    public void moveToProfileActivity () {
        //TODO: to be implemented, for now move back to main
        backToMainActivity(); //TODO: fix this later
    }

    public boolean login(View view) {
        String usernameText = username.getText().toString();
        String passwordText = password.getText().toString();

        LoginSession session = accountManager.authMemberLogin(usernameText, passwordText);

        boolean isSucceed = session.isLogined();

        return isSucceed;
    }


}