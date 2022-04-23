package ca.umanitoba.personalhealthcare.presentation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import ca.umanitoba.personalhealthcare.R;
import ca.umanitoba.personalhealthcare.business.AccountManager;
import ca.umanitoba.personalhealthcare.business.AccountManagerImp;
import ca.umanitoba.personalhealthcare.objects.EmailExistException;
import ca.umanitoba.personalhealthcare.objects.EmailInvalidException;
import ca.umanitoba.personalhealthcare.objects.Member;
import ca.umanitoba.personalhealthcare.objects.PasswordInvalidException;

public class CreateAccountActivity extends AppCompatActivity {

    AccountManager accountManager;

    EditText emailInput;
    EditText passwordInput;

    TextView createFeedback;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);

        accountManager = new AccountManagerImp();

        emailInput = findViewById(R.id.emailInput);
        passwordInput = findViewById(R.id.passwordInput);

        createFeedback = (TextView) findViewById(R.id.createAccountFeedback);
        restartView();
    }

    private void restartView () {
        createFeedback.setVisibility(View.GONE);

    }

    public void onClickCreateAccount(View v) {
        restartView();

        String email = emailInput.getText().toString();
        String password = passwordInput.getText().toString();

        System.out.println("Create... " + email + " - " + password);
        try {
            Member newMember = accountManager.createAccount(email, password);
            succeedCreating();
        } catch (PasswordInvalidException e) {
            notifyPasswordInvalid(e);
        } catch (EmailInvalidException e) {
            notifyEmailInvalid(e);

        } catch (EmailExistException e) {
            notifyEmailExist(e);
        }
    }

    void succeedCreating () {
        feedbackException("Account is created", Color.GREEN);
        openLoginActivity();
        System.out.println("Move to login page now");
    }

    void notifyEmailInvalid(EmailInvalidException e) {
        feedbackException(e.getMessage(), Color.RED);
    }

    void notifyPasswordInvalid(PasswordInvalidException e) {
        feedbackException(e.getMessage(), Color.RED);

    }

    void notifyEmailExist(EmailExistException e) {
        feedbackException(e.getMessage(), Color.RED);

    }


    void feedbackException(String message, int color) {
        createFeedback.setText(message);
        createFeedback.setVisibility(View.VISIBLE);
        createFeedback.setTextColor(color);
    }

    void openLoginActivity () {
        Intent i = new Intent( this, LogInActivity.class);
        startActivity(i);
    }
}