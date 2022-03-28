package ca.umanitoba.personalhealthcare.persistence;

import java.io.FileWriter;
import java.io.IOException;
import ca.umanitoba.personalhealthcare.objects.Symptom;

public class ReportSymptoms {

    public ReportSymptoms(Symptom symptom){

        try (FileWriter writer = new FileWriter("ReportedSymptoms.txt")) {
            writer.write(symptom.toString() + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
