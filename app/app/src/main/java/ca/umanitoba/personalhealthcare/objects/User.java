package ca.umanitoba.personalhealthcare.objects;

public abstract class User {
    protected String id;

    public User(String id) {
        this.id = id;
    }

    public String getID() {
        return this.id;
    }

    public void setID(String id) {
        this.id = id;
    }
}
