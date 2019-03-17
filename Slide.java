import java.util.List;
import java.util.Set;

public class Slide {
    private List<Integer> ids;
    private Set<String> tags;

    public Slide() {

    }


    public Slide(List<Integer> ids, Set<String> tags) {
        super();
        this.ids = ids;
        this.tags = tags;
    }

    public List<Integer> getIds() {
        return ids;
    }

    public void setIds(List<Integer> ids) {
        this.ids = ids;
    }

    public Set<String> getTags() {
        return tags;
    }

    public void setTags(Set<String> tags) {
        this.tags = tags;
    }

}