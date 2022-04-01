package ca.umanitoba.personalhealthcare.objects;

public class Symptom {
    String name;
    String description;

    public Symptom(String name, String description){
        this.name = name;
        this.description = description;
    }
    public String getDescription() {
        return description;
    }
    public String getSymptomName() {
        return name;
    }

    public boolean equals(Symptom other){
        return other.getSymptomName().equalsIgnoreCase(name);
    }

    public String toString() {return name;}
}
