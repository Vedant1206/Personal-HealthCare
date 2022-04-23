package ca.umanitoba.personalhealthcare.presentation;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import ca.umanitoba.personalhealthcare.R;
import ca.umanitoba.personalhealthcare.application.MainActivity;
import ca.umanitoba.personalhealthcare.business.ProfileManager;
import ca.umanitoba.personalhealthcare.business.ProfileManagerImp;
import ca.umanitoba.personalhealthcare.business.SessionManager;
import ca.umanitoba.personalhealthcare.business.SessionManagerImp;
import ca.umanitoba.personalhealthcare.objects.Profile;
import ca.umanitoba.personalhealthcare.persistence.fakeDb.FakeProfilePersistence;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class SelectProfileActivity extends AppCompatActivity implements ProfileItemViewList{

    ListView profilesListView;
    SessionManager sessionManager;
    ProfilesAdapter profilesAdapter;
    ProfileManager profileManager;

    List<Profile> profileList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_profile);

        profilesListView = (ListView) findViewById(R.id.select_profile_profile_list);

        sessionManager = new SessionManagerImp();
        profileManager = new ProfileManagerImp(FakeProfilePersistence.getProfilePersistence());

        //Fake data
        profileList = new ArrayList<>();
        profileList.add(new Profile(sessionManager.retrieveSession().getMemberEmail(), "Default", "",
        150, 60,
        2000, 05, 25,
        "male"));
        profileList.add(new Profile(sessionManager.retrieveSession().getMemberEmail(), "Default2", "",
                150, 60,
                2000, 05, 25,
                "male"));
        if (!sessionManager.retrieveSession().isLogined()) {
            backToMain();
        } else {
            profileList = profileManager.getProfiles(sessionManager.retrieveSession().getMemberEmail());
        }
        profilesAdapter = new ProfilesAdapter(this, R.layout.profile_item, profileList, this);
        profilesListView.setAdapter(profilesAdapter);


    }

    public void selectProfile (Profile profile) {
        sessionManager.saveSessionProfile(profile);
        backToMain();
    }


     void backToMain() {
        Intent intentMain = new Intent(this, MainActivity.class);
        startActivity(intentMain);
    }

    @Override
    public void editProfile(Profile profile) {
        String profileName = profile.getName();
        String email = profile.getEmail();

        Bundle bundle = new Bundle();
        bundle.putString("profileName", profileName);
        bundle.putString("email", email);

        //TODO: to be implemented
        //Intent intentEdit = new Intent(this, EditProfileActivity.class)
        //startActivity(intentEdit, bundle);
    }
}

interface ProfileItemViewList {
    void editProfile(Profile profile);
    void selectProfile (Profile profile);
}

class ProfilesAdapter extends ArrayAdapter<Profile> {
    int resource;
    ProfileItemViewList functions;

    public ProfilesAdapter(@NonNull Context context, int resource, @NonNull List<Profile> objects, ProfileItemViewList profileItemFunction) {
        super(context, resource, objects);
        this.resource = resource;
        functions = profileItemFunction;

        System.out.println("Start adapter");
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LinearLayout profileItem;
        Profile profile = getItem(position);

        if (convertView == null) {
            profileItem = new LinearLayout(getContext());
            String inflater = Context.LAYOUT_INFLATER_SERVICE;
            LayoutInflater vi;
            vi = (LayoutInflater) getContext().getSystemService(inflater);
            vi.inflate(resource, profileItem, true);
        } else {
            profileItem = (LinearLayout) convertView;
        }

        TextView profileNameView = (TextView) profileItem.findViewById(R.id.profile_item_name);

        AppCompatButton selectButton = (AppCompatButton) profileItem.findViewById(R.id.profile_item_select);
        AppCompatButton editButton = (AppCompatButton) profileItem.findViewById(R.id.profile_item_edit);

        profileNameView.setText(profile.getName());
        System.out.println("Show profile name: " + profile.getName());
        selectButton.setOnClickListener(view -> {
            functions.selectProfile(profile);
        });

        editButton.setOnClickListener(view -> {
            functions.editProfile(profile);
        });


        return profileItem;
    }

}