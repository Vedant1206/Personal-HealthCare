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

    public String getName() {return name;}
    public String getSourceLink() {return sourceLink;}
    public String getSourceName() {return sourceName;}
    public String getDescription() {return description;}

    public boolean equals(Condition other) {
        return other.getName().equalsIgnoreCase(name) &&
                other.getSourceName().equalsIgnoreCase(sourceName) &&
                other.sourceLink.equals(sourceLink);
    }
}
