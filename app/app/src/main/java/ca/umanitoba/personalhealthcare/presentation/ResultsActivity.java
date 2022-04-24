package ca.umanitoba.personalhealthcare.presentation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import ca.umanitoba.personalhealthcare.R;
import ca.umanitoba.personalhealthcare.business.ResultsLogic;
import ca.umanitoba.personalhealthcare.business.ResultsLogicImp;

/**
 * This class is displaying the description
 * of whatever symptom we are clicking
 * */
public class ResultsActivity extends AppCompatActivity {

    ResultsLogic thisLogic;
    String conditionToShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        Intent i = getIntent();
        Bundle b = i.getExtras();
        conditionToShow = b.getString("Name");
        thisLogic = new ResultsLogicImp(conditionToShow);
        setTitle(conditionToShow);

        TextView nameText = (TextView) findViewById(R.id.textView9);
        TextView linkText = (TextView) findViewById(R.id.textView11);
        TextView descriptionText = (TextView) findViewById(R.id.textView10);
        TextView linkNameText = (TextView) findViewById(R.id.textView);

        nameText.setText(thisLogic.getCondition().getName());
        linkText.setText(thisLogic.getCondition().getSourceLink());
        descriptionText.setText(thisLogic.getCondition().getDescription());
        linkNameText.setText(thisLogic.getCondition().getSourceName());

    }
}
