import java.util.*;

public class SlideCreator {
    public static List<Slide> coupleVertical(List<Photo> photos) {
        ArrayList<Slide> slideList = new ArrayList<Slide>();
        ArrayList<Photo> verticalPhotos = new ArrayList<Photo>();
        for (Photo i : photos) {
            if (i.getType() == 'V') {
                verticalPhotos.add(i);
            } else {
                Set<String> tags = new HashSet<String>();
                tags.addAll(i.getTags());
                List<Integer> ids = new ArrayList<Integer>();
                ids.add(new Integer(i.getId()));
                Slide slide = new Slide(ids, tags);
                slideList.add(slide);
            }
        }
        Collections.sort(verticalPhotos);
        for (int i = 0; i < verticalPhotos.size()-1; i+=2) {
            int count = 0;
            int max = 0;
            int ind = 0;
			/*for (int j = i + 1; j < verticalPhotos.size(); j++) {
				for (int k = 0; k < verticalPhotos.get(i).getTags().size(); k++) {
					if (verticalPhotos.get(j).getTags().contains(verticalPhotos.get(i).getTags().get(k))) {
						count++;
					}
				}
				//System.out.println(count);
				if (count > max) {
					max = count;
					ind = j;
				}
			}*/
            //if (max != 0) {
            Set<String> tags = new HashSet<String>();
            tags.addAll(verticalPhotos.get(i).getTags());
            tags.addAll(verticalPhotos.get(i+1).getTags());
            List<Integer> ids = new ArrayList<Integer>();
            ids.add(new Integer(verticalPhotos.get(i).getId()));
            ids.add(new Integer(verticalPhotos.get(i+1).getId()));
            Slide slide = new Slide(ids, tags);
            slideList.add(slide);
            verticalPhotos.remove(ind);
            //}
        }
        return slideList;
    }
}