package ca.umanitoba.personalhealthcare.objects;

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

    public boolean equals(Symptom other){
        return other.getSymptomName().equalsIgnoreCase(name);
    }

    public String toString() {return name;}
}


