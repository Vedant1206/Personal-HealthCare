package ca.umanitoba.personalhealthcare.presentation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.Calendar;

import ca.umanitoba.personalhealthcare.R;
import ca.umanitoba.personalhealthcare.application.MainActivity;
import ca.umanitoba.personalhealthcare.business.ProfileManager;
import ca.umanitoba.personalhealthcare.business.ProfileManagerImp;
import ca.umanitoba.personalhealthcare.business.SessionManager;
import ca.umanitoba.personalhealthcare.business.SessionManagerImp;
import ca.umanitoba.personalhealthcare.objects.Profile;
import ca.umanitoba.personalhealthcare.persistence.fakeDb.FakeProfilePersistence;

public class EditProfileActivity extends AppCompatActivity {
    Profile profile;
    ProfileManager profileManager;

    TextInputEditText profileNameInput;
    TextInputEditText addressInput;
    TextInputEditText weightInput;
    TextInputEditText heightInput;
    EditText birthdayInput;
    TextInputEditText sexInput;

    AppCompatButton saveButton;
    AppCompatButton cancelButton;

    DatePickerDialog picker;

    String initProfileName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        System.out.println("Opened editing...");

        profileNameInput = (TextInputEditText) findViewById(R.id.edit_profile_profile_name);
        addressInput = (TextInputEditText) findViewById(R.id.edit_profile_address);
        weightInput = (TextInputEditText) findViewById(R.id.edit_profile_weight);
        heightInput = (TextInputEditText) findViewById(R.id.edit_profile_height);
        birthdayInput = (EditText) findViewById(R.id.edit_profile_birthday);
        sexInput = (TextInputEditText) findViewById(R.id.edit_profile_sex);
        saveButton = (AppCompatButton) findViewById(R.id.edit_profile_save);
        cancelButton = (AppCompatButton) findViewById(R.id.edit_profile_cancel);

        profileManager = new ProfileManagerImp(FakeProfilePersistence.getProfilePersistence());

        Bundle bundle = this.getIntent().getExtras();
        if (bundle != null) {
            String email = bundle.getString("edit_key_email");
            initProfileName = bundle.getString("edit_key_profile_name");
            System.out.println("Retrieve from bundle: " + email + " - " + initProfileName);
            profile = getProfileToEdit(email, initProfileName, profileManager);
        } else {
            backToMain();
        }

        if (profile == null) {
            backToMain();
        }

        profileNameInput.setText(profile.getName());
        addressInput.setText(profile.getAddress());
        weightInput.setText(profile.getWeight() + "");
        heightInput.setText(profile.getHeight() + "");
        sexInput.setText(profile.getSex());
        birthdayInput.setText(profile.getDay() + "/" + profile.getMonth() + "/" + profile.getYear());

        addressInput.setText(profile.getAddress());
        weightInput.setText(profile.getWeight() + "");
        heightInput.setText(profile.getHeight() + "");
        sexInput.setText(profile.getSex());

        birthdayInput.setInputType(InputType.TYPE_NULL);
        birthdayInput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Calendar cldr = Calendar.getInstance();
                int day = cldr.get(Calendar.DAY_OF_MONTH);
                int month = cldr.get(Calendar.MONTH);
                int year = cldr.get(Calendar.YEAR);
                // date picker dialog
                picker = new DatePickerDialog(EditProfileActivity.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                                birthdayInput.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);
                                profile.setDay(dayOfMonth);
                                profile.setMonth(monthOfYear + 1);
                                profile.setYear(year);
                            }
                        }, year, month, day);
                picker.show();
            }
        });

        saveButton.setOnClickListener(view -> {
            profile.setName(profileNameInput.getText().toString());
            profile.setAddress(addressInput.getText().toString());
            profile.setWeight(Integer.parseInt(weightInput.getText().toString()));
            profile.setHeight(Integer.parseInt(heightInput.getText().toString()));
            profile.setSex(sexInput.getText().toString());

            saveProfile (profile);
        });

        cancelButton.setOnClickListener(view -> {
            finish();
        });
    }

    private void saveProfile(Profile profile) {
        profileManager.updateProfileName(profile, initProfileName);
        profileManager.updateProfile(profile);
        backToSelectProfiles();
    }

    private Profile getProfileToEdit(String email, String profileName, ProfileManager profileManager) {
        if (email == null | email.equals("")) {
            backToMain();
            return null;
        }

        if (profileName == null || profileName.equals("")) {
            backToSelectProfiles();
            return null;
        }

        return profileManager.getProfile(email, profileName);
    }

    private void backToMain() {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }

    private void backToSelectProfiles() {
        Intent i = new Intent(this, SelectProfileActivity.class);
        startActivity(i);
    }
}