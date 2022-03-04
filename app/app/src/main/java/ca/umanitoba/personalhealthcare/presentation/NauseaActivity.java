package ca.umanitoba.personalhealthcare.presentation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import ca.umanitoba.personalhealthcare.R;

public class NauseaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nausea);
        TextView t = findViewById(R.id.nauseaTextView);
        t.setText("Take it easy. Too much activity and not getting enough rest might make " +
                "nausea worse.\n" +
                "Stay hydrated. Take small sips of cold, clear, carbonated or sour drinks," +
                " such as ginger ale, lemonade and water. Mint tea also may help. Oral rehydration" +
                " solutions, such as Pedialyte, can aid in preventing dehydration.\n" +
                "Avoid strong odors and other triggers. Food and cooking smells, perfume, " +
                "smoke, stuffy rooms, heat, humidity, flickering lights, and driving are among" +
                " the possible triggers of nausea and vomiting.\n" +
                "Eat bland foods. Start with easily digested foods such as gelatin, crackers and" +
                " toast. When you can keep these down, try cereal, rice, fruit, and salty or" +
                " high-protein, high-carbohydrate foods. Avoid fatty or spicy foods. Wait to " +
                "eat solid foods until about six hours after the last time you vomited.\n" +
                "Use over-the-counter (OTC) motion sickness medicines. If you're planning a trip," +
                " OTC motion sickness drugs, such as dimenhydrinate (Dramamine) or meclizine " +
                "(Rugby Travel Sickness) may help calm your queasy stomach. For longer journeys, " +
                "such as a cruise, ask your doctor about prescription motion sickness adhesive " +
                "patches, such as scopolamine (Transderm Scop).");
    }
}