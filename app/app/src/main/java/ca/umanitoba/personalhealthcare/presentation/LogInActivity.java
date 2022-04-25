package ca.umanitoba.personalhealthcare.presentation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
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

public class LogInActivity extends AppCompatActivity {

    private EditText username;                  //username text box
    private EditText password;                  //password text box
    private AppCompatButton loginBtn;           //login button
    private TextView feedbackTextView;          //feedback text

    private AccountManager accountManager;      //account manager
    private SessionManager sessionManager;      //session manager

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
        Intent i = new Intent(this, SelectProfileActivity.class);
        startActivity(i);
    }

    public boolean login(View view) {
        String usernameText = username.getText().toString();
        String passwordText = password.getText().toString();

        LoginSession session = accountManager.authMemberLogin(usernameText, passwordText);

        boolean isSucceed = session.isLogined();

        return isSucceed;
    }


}