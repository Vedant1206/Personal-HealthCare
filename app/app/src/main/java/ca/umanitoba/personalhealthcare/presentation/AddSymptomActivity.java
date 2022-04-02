package ca.umanitoba.personalhealthcare.presentation;

import android.content.Intent;
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
import ca.umanitoba.personalhealthcare.business.AddSymptomLogicImp;

public class AddSymptomActivity extends AppCompatActivity {

    private EditText symptomName;
    private EditText editTextC1;
    private EditText editTextC2;
    private EditText editTextC3;
    private CheckBox checkHead;
    private CheckBox checkChest;
    private CheckBox checkStomach;
    private CheckBox checkEverywhere;
    private AddSymptomLogic thisLogic;
    private Button submitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_symptom);
        setTitle("Report a Missing Symptom");

        symptomName = findViewById(R.id.symptomName);
        editTextC1 = findViewById(R.id.editTextC1);
        editTextC2 = findViewById(R.id.editTextC2);
        editTextC3 = findViewById(R.id.editTextC3);
        checkHead = findViewById(R.id.checkHead);
        checkChest = findViewById(R.id.checkChest);
        checkStomach = findViewById(R.id.checkStomach);
        checkEverywhere = findViewById(R.id.checkEverywhere);
        submitButton = findViewById(R.id.submitButton);

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
                        } else if(!head && !chest && !stomach && !everywhere) {
                            Toast.makeText(getApplicationContext(), "Please select the affected body parts", Toast.LENGTH_SHORT).show();
                        } else {
                            thisLogic = new AddSymptomLogicImp(sympName, condition1, condition2, condition3, head, chest, stomach, everywhere);
                            if(reportSymptom(thisLogic.getSymptomString())) {
                                Toast.makeText(getApplicationContext(), "Thank you for your submission", Toast.LENGTH_SHORT).show();
                                backToSearch();
                            } else {
                                Toast.makeText(getApplicationContext(), "oops", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }
                    public void backToSearch(){
                        Intent i = new Intent(AddSymptomActivity.this, SearchActivity.class);
                        startActivity(i);
                    }
                    public Boolean reportSymptom(String symptomString){
                        Boolean returnValue = false;
                        try {
                            FileOutputStream fileout=openFileOutput("ReportedSymptoms.txt", MODE_PRIVATE);
                            OutputStreamWriter outputWriter=new OutputStreamWriter(fileout);
                            outputWriter.write(symptomString + "\n");
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