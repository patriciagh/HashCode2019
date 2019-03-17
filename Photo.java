import java.util.ArrayList;
import java.util.List;

public class Photo implements Comparable {
    private char type; //H sau V
    private int numberOfTags;
    private List<String> tags = new ArrayList<String>();
    private int id;

    public int getId() {
        return id;
    }

    public Photo(int id, char type, int numberOfTag, List<String> tags) {
        this.type = type;
        this.numberOfTags = numberOfTag;
        this.tags = tags;
        this.id = id;

    }


    public void setId(int id) {
        this.id = id;
    }

    public void setType(char type) {
        this.type = type;
    }

    public void setNumberOfTags(int numberOfTags) {
        this.numberOfTags = numberOfTags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public int getNumberOfTags() {
        return numberOfTags;
    }

    public List<String> getTags() {
        return tags;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        result = prime * result + numberOfTags;
        result = prime * result + ((tags == null) ? 0 : tags.hashCode());
        result = prime * result + type;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Photo other = (Photo) obj;
        if (id != other.id)
            return false;
        if (numberOfTags != other.numberOfTags)
            return false;
        if (tags == null) {
            if (other.tags != null)
                return false;
        } else if (!tags.equals(other.tags))
            return false;
        if (type != other.type)
            return false;
        return true;
    }

    public char getType() {
        return type;
    }

    public int compareTo(Object photo) {
        return this.numberOfTags - ((Photo) photo).getNumberOfTags();
    }
}