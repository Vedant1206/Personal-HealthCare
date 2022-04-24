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

    @Override
    public boolean equals(Object other) {
        boolean result = false;

        if(other instanceof Condition) {
            result = ((Condition) other).getName().equalsIgnoreCase(name) &&
                    ((Condition) other).getSourceName().equalsIgnoreCase(sourceName) &&
                    ((Condition) other).sourceLink.equals(sourceLink);
        }

        return result;
    }
}
