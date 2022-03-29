package ca.umanitoba.personalhealthcare.presentation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import ca.umanitoba.personalhealthcare.R;

public class BodyPartsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_body_parts);
    }

    public void clickHead(View v){
        Intent i = new Intent(this, HeadActivity.class);
        String name = "Head";
        String[] symptoms = {"Headache", "Congestion", "Sore throat"}; //menu listr

        i.putExtra("ID", symptoms);
        i.putExtra("Name", name);
        startActivity(i);
    }

    public void clickStomach(View v){
        Intent i = new Intent(this, HeadActivity.class);

        String name = "Stomach";
        String[] symptoms = {"Nausea", "Stomach pain", "Bloating"}; //menu listr

        i.putExtra("ID", symptoms);
        i.putExtra("Name", name);

        startActivity(i);
    }

    public void clickChest(View v){
        Intent i = new Intent(this, HeadActivity.class);

        String name = "Chest";
        String[] symptoms = {"Chest pain", "Shortness of breath", "Itchiness"}; //menu listr

        i.putExtra("ID", symptoms);
        i.putExtra("Name", name);

        startActivity(i);
    }

}