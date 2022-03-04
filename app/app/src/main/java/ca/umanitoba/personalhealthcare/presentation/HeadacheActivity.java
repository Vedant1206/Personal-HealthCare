package ca.umanitoba.personalhealthcare.presentation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import ca.umanitoba.personalhealthcare.R;

public class HeadacheActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_headache);
        TextView t = findViewById(R.id.headacheTextView);
        t.setText("Tension-type headaches\n" +
                "Tension-type headaches, the most common variety of headaches:\n" +
                "\n" +
                "Might be felt as a tight band of pain around your head, a dull ache or pressure\n" +
                "Might cause mild to moderate pain on both sides of the head\n" +
                "Vary widely in frequency\n" +
                "Can be occasional\n" +
                "May occur more than 15 days a month (chronic)\n" +
                "Last from 30 minutes to a week\n" +
                "Treatment\n" +
                "Most occasional tension-type headaches are easily treated with over-the-counter medications, including:\n" +
                "\n" +
                "Aspirin\n" +
                "Ibuprofen (Advil, Motrin IB, others)\n" +
                "Acetaminophen (Tylenol, others)\n" +
                "Daily prescription medications, including tricyclic antidepressants, might manage chronic tension-type headaches. Alternative therapies aimed at stress reduction might help. They include:\n" +
                "\n" +
                "Cognitive behavioral therapy\n" +
                "Biofeedback\n" +
                "Massage therapy\n" +
                "Acupuncture\n" +
                "Migraines\n" +
                "Migraines are another common type of headache. They affect three times more women than men. Migraines typically:\n" +
                "\n" +
                "Cause pain that is moderate to severe\n" +
                "Pulsate\n" +
                "Cause nausea, vomiting, or increased sensitivity to light or sound\n" +
                "Affect only one side of your head, but can affect both sides\n" +
                "Worsen with activity such as climbing steps\n" +
                "Last from four to 72 hours without treatment\n" +
                "Treatment\n" +
                "Migraine treatment is aimed at relieving symptoms and preventing additional attacks. If you know what triggers your migraines, avoiding those triggers and learning how to manage them can help prevent migraines or lessen the pain. Treatment might include:\n" +
                "\n" +
                "Rest in a quiet, dark room\n" +
                "Hot or cold compresses to your head or neck\n" +
                "Massage and small amounts of caffeine\n" +
                "Over-the-counter medications such as ibuprofen (Advil, Motrin IB, others), acetaminophen (Tylenol, others) and aspirin\n" +
                "Prescription medications including triptans, such as sumatriptan (Imitrex) and zolmitriptan (Zomig)\n" +
                "Preventive medications such as metoprolol (Lopressor), propranolol (Innopran, Inderal, others), amitriptyline, divalproex (Depakote), topiramate (Qudexy XR, Trokendi XR ,Topamax) or erenumab-aooe (Aimovig)" +
                "Source -> https://www.mayoclinic.org/diseases-conditions/chronic-daily-headaches/in-depth/headaches/art-20047375");
    }

}