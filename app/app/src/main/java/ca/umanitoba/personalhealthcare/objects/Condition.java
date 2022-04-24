package ca.umanitoba.personalhealthcare.objects;

/**
 * This DSO class holds Condition details within the object
 */
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

        //we dont check description to decide whether objects are equal to each other
        if(other instanceof Condition) {
            result = ((Condition) other).getName().equalsIgnoreCase(name) &&
                    ((Condition) other).getSourceName().equalsIgnoreCase(sourceName) &&
                    ((Condition) other).sourceLink.equals(sourceLink);
        }

        return result;
    }
}
