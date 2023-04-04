package Entity;

public class Designation {
    

    
    private String name;
    private String description;

    public Designation() {
    }

    public Designation( String name, String description) {
       
        this.name = name;
        this.description = description;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Designation{" +  ", name=" + name + ", description=" + description + '}';
    }

}
