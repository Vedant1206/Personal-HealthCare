package ca.umanitoba.personalhealthcare.objects;

public class Condition {
    private String name;
    private String sourceName;
    private String sourceLink;

    public Condition(String name, String sourceName, String sourceLink){
        this.name = name;
        this.sourceLink = sourceLink;
        this.sourceName = sourceName;
    }

    public String getName() {return name;}
    public String getSourceLink() {return sourceLink;}
    public String getSourceName() {return sourceName;}
}
