package ca.umanitoba.personalhealthcare.presentation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import ca.umanitoba.personalhealthcare.R;
import ca.umanitoba.personalhealthcare.business.DataActivityClass;

/**
 * This class is displaying the description
 * of whatever symptom we are clicking
 * */
public class ResultsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_headache);

        //getting the textview id
        TextView t = findViewById(R.id.headacheTextView);

        //getting the extra data we passed in Search Activity
        Bundle b = getIntent().getExtras();
        String name = b.getString("Name");

        //Using dataClassActivity as the a SearchActivityManager
        DataActivityClass data = new DataActivityClass();
        String description = data.getName(name);

        //Printing the description on the textView
        t.setText(description);
    }
}
