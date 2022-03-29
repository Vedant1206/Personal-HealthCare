package ca.umanitoba.personalhealthcare.objects;

public class Condition {
    private String name;
    private String sourceName;
    private String sourceLink;
    private String description;

    public Condition(String name, String sourceName, String sourceLink, String description){
        this.name = name;
        this.sourceLink = sourceLink;
        this.sourceName = sourceName;
        this.description = description;
    }
}
