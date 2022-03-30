package ca.umanitoba.personalhealthcare.presentation;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

import ca.umanitoba.personalhealthcare.R;
import ca.umanitoba.personalhealthcare.business.AddSymptomLogic;
import ca.umanitoba.personalhealthcare.objects.Symptom;

public class AddSymptomActivity extends AppCompatActivity {

    EditText symptomName;
    EditText editTextC1;
    EditText editTextC2;
    EditText editTextC3;
    CheckBox checkHead;
    CheckBox checkChest;
    CheckBox checkStomach;
    CheckBox checkEverywhere;
    Button submitButton;
    AddSymptomLogic thisLogic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_symptom);

        symptomName = (EditText) findViewById(R.id.symptomName);
        editTextC1 = (EditText) findViewById(R.id.editTextC1);
        editTextC2 = (EditText) findViewById(R.id.editTextC2);
        editTextC3 = (EditText) findViewById(R.id.editTextC3);
        checkHead = (CheckBox) findViewById(R.id.checkHead);
        checkChest = (CheckBox) findViewById(R.id.checkChest);
        checkStomach = (CheckBox) findViewById(R.id.checkStomach);
        checkEverywhere = (CheckBox) findViewById(R.id.checkEverywhere);
        submitButton = (Button) findViewById(R.id.submitButton);

        submitButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String sympName = symptomName.getText().toString();
                        String condition1 = editTextC1.getText().toString();
                        String condition2 = editTextC2.getText().toString();
                        String condition3 = editTextC3.getText().toString();
                        Boolean head = checkHead.isChecked();
                        Boolean chest = checkChest.isChecked();
                        Boolean stomach = checkStomach.isChecked();
                        Boolean everywhere = checkEverywhere.isChecked();
                        if(sympName.isEmpty()) {
                            Toast.makeText(getApplicationContext(), "Please enter the name of the symptom", Toast.LENGTH_SHORT).show();
                        } else if(head == false && chest == false && stomach == false && everywhere == false) {
                            Toast.makeText(getApplicationContext(), "Please select the affected body parts", Toast.LENGTH_SHORT).show();
                        } else {
                            thisLogic = new AddSymptomLogic(sympName, condition1, condition2, condition3, head, chest, stomach, everywhere);
                            if(reportSymptom(thisLogic.getThisSymptom())) {
                                Toast.makeText(getApplicationContext(), "Thank you for your submission", Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(getApplicationContext(), "oops", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }
                    public Boolean reportSymptom(Symptom thisSymptom){
                        Boolean returnValue = false;
                        try {
                            FileOutputStream fileout=openFileOutput("ReportedSymptoms.txt", MODE_PRIVATE);
                            OutputStreamWriter outputWriter=new OutputStreamWriter(fileout);
                            outputWriter.write(thisSymptom.toString() + "\n");
                            outputWriter.close();
                            returnValue = true;
                        } catch (Exception e) {
                            e.printStackTrace();
                            returnValue = false;
                        }
                        return returnValue;
                    }
                }
        );

    }
}