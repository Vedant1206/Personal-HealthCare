package ca.umanitoba.personalhealthcare.presentation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import ca.umanitoba.personalhealthcare.R;
import ca.umanitoba.personalhealthcare.business.BodyPartsLogic;
import ca.umanitoba.personalhealthcare.business.BodyPartsLogicImp;

/**
 * BodyPartsActivity has picture of a body
 * The User can click on the different parts
 * of the body to see a list of symptoms
 * that could affect that body part.
 * */
public class BodyPartsActivity extends AppCompatActivity {

    private BodyPartsLogic thisLogic;   //Logic class


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_body_parts);
        setTitle("Search By Picture");
    }

    /**
     * User clicks on head.
     * */
    public void clickHead(View v){
        thisLogic = new BodyPartsLogicImp("head");
        start(thisLogic);
    }

    /**
     * User clicks on stomach.
     * */
    public void clickStomach(View v){
        thisLogic = new BodyPartsLogicImp("stomach");
        start(thisLogic);
    }

    /**
     * User clicks on chest.
     * */
    public void clickChest(View v){
        thisLogic = new BodyPartsLogicImp("chest");
        start(thisLogic);
    }

    /**
     * Start the next activity.
     * */
    public void start(BodyPartsLogic thisLogic){
        Intent i = new Intent(this, SearchActivity.class);
        i.putExtra("ID", thisLogic.getSymptoms());
        i.putExtra("Name", thisLogic.getName());
        startActivity(i);
    }

}