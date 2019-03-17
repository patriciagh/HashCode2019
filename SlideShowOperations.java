import java.util.ArrayList;
import java.util.List;

public class SlideShowOperations {

    public static List<Slide> sortSlideShow(List<Slide> slidesToSort) {
        List<Slide> slides = new ArrayList<>();
        for (Slide slide : slidesToSort) {
            slides.add(slide);
        }
        for (int i = 0; i < slides.size() - 2; i++) {
            Slide firstSlide = slides.get(i);
            Slide secondSlide = slides.get(i + 1);
            Slide thirdSlide = slides.get(i + 2);
            int firstPhotoInterest = getInterestFactor(firstSlide, secondSlide);
            int secondPhotoInterest = getInterestFactor(secondSlide, thirdSlide);
            if (secondPhotoInterest < firstPhotoInterest) {
                //System.out.println("test " + i);
                Slide newFirstSlide = new Slide(secondSlide.getIds(), secondSlide.getTags());
                Slide newSecondSlide = new Slide(firstSlide.getIds(), firstSlide.getTags());
                slides.set(i, newFirstSlide);
                slides.set(i + 1, newSecondSlide);
                //System.out.println(slides.get(i).getIds());
                //System.out.println(slides.get(i+1).getIds());
                //i = 0;
            }
        }
        return slides;
    }

    public static int getInterestFactor(Slide firstSlide, Slide secondSlide) {
        return Math.min(getNumberOfCommonTags(firstSlide, secondSlide), Math.min(getNumberOfTagsThatAreInFirstSlideAndNotInSecond(firstSlide, secondSlide),
                getNumberOfTagsThatAreInFirstSlideAndNotInSecond(secondSlide, firstSlide)));
    }

    public static int getNumberOfCommonTags(Slide firstSlide, Slide secondSlide) {
        int numberOfCommonTags = 0;
        for (String slideTag : firstSlide.getTags()) {
            if (secondSlide.getTags().contains(slideTag)) {
                numberOfCommonTags++;
            }
        }
        return numberOfCommonTags;
    }

    public static int getNumberOfTagsThatAreInFirstSlideAndNotInSecond(Slide firstSlide, Slide secondSlide) {
        int numberOfTagsThatAreInFirstSlideAndNotInSecond = 0;
        for (String slideType : firstSlide.getTags()) {
            if (!secondSlide.getTags().contains(slideType)) {
                numberOfTagsThatAreInFirstSlideAndNotInSecond++;
            }
        }
        return numberOfTagsThatAreInFirstSlideAndNotInSecond;
    }

}
