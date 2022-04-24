package ca.umanitoba.personalhealthcare.objects;

/**
 * This DSO class holds Symptom details within the object
 */
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
    public String getSymptomName() { return name; }

    @Override
    public boolean equals(Object other) {
        boolean result = false;

        if (other instanceof Symptom) {
            result = ((Symptom) other).getSymptomName().equalsIgnoreCase(name) && ((Symptom) other).getBodyPart().equalsIgnoreCase(bodyPart);
        }

        return result;
    }

    public String toString() {return name;}
}


