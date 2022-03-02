package ca.umanitoba.personalhealthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Cold_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cold);
        TextView t = findViewById(R.id.coldTextView);
        t.setText("Cough syrups\n" +
                "Over-the-counter cough and cold medicines are intended to treat the symptoms" +
                " of coughs and colds, not the underlying disease. Research suggests that " +
                "these medicines haven't been proved to work any better to treat colds than " +
                "do inactive medicine (placebo).\n" +
                "\n" +
                "If you use over-the counter cough and cold medicines, follow the label " +
                "directions. Don't take two medicines with the same active ingredient," +
                " such as an antihistamine, decongestant or pain reliever. Too much of a " +
                "single ingredient could lead to an accidental overdose.\n" +
                "\n" +
                "Don't use over-the-counter medicines, except for fever reducers and pain " +
                "relievers, to treat coughs and colds in children younger than 6 years old." +
                " Cough and cold medications have potentially serious side effects, including " +
                "fatal overdoses in children younger than 2 years old. Also consider avoiding" +
                " use of these medicines for children younger than 12 years old. And it isn't" +
                " typically recommended that you give cough or cold medicines to an older child.");
    }
}