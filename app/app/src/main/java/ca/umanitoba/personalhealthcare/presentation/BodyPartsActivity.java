package ca.umanitoba.personalhealthcare.presentation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import ca.umanitoba.personalhealthcare.R;
import ca.umanitoba.personalhealthcare.business.BodyPartsLogic;

public class BodyPartsActivity extends AppCompatActivity {

    BodyPartsLogic thisLogic;
    Intent i = new Intent(this, HeadActivity.class);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_body_parts);
    }

    public void clickHead(View v){
        thisLogic = new BodyPartsLogic("head");
        start(thisLogic);
    }

    public void clickStomach(View v){
        thisLogic = new BodyPartsLogic("stomach");
        start(thisLogic);
    }

    public void clickChest(View v){
        thisLogic = new BodyPartsLogic("chest");
        start(thisLogic);
    }

    public void start(BodyPartsLogic thisLogic){
        i.putExtra("ID", thisLogic.getSymptomStrings());
        i.putExtra("Name", thisLogic.getName());
        startActivity(i);
    }

}