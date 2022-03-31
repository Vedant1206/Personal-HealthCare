package ca.umanitoba.personalhealthcare.objects;

public class Symptom {
    private String name;

    public Symptom(String name){
        this.name = name;
    }

    public String getSymptomName() {return name;}

    public String toString() {return name;}
}
