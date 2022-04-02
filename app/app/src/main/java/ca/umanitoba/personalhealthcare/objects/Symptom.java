package ca.umanitoba.personalhealthcare.objects;

import androidx.annotation.NonNull;

public class Symptom {
    String name;
    String bodyPart;

    public Symptom(String name, String bodyPart){
        this.name = name;
        this.bodyPart = bodyPart;
    }
    public String getBodyPart() {
        return bodyPart;
    }
    public String getSymptomName() {
        return name;
    }

    public boolean equals(@NonNull Symptom other){
        return other.getSymptomName().equalsIgnoreCase(name) && other.getBodyPart().equalsIgnoreCase(bodyPart);
    }

    public String toString() {return name;}
}


