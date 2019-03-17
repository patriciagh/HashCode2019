import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String path = scanner.nextLine();
        List<Photo> photos = FileOperator.readFromFile(path);
        System.out.println("after read from file");
//        for (int i = 0; i < photos.size(); i++) {
//            System.out.println(photos.get(i).getId());
//        }
        List<Slide> slides = SlideCreator.coupleVertical(photos);
        System.out.println("after couple Vertical");
//        for (int i = 0; i < slides.size() - 1; i++) {
//            System.out.println(slides.get(i).getIds() + " " + SlideShowOperations.getInterestFactor(slides.get(i), slides.get(i + 1)));
//        }
        List<Slide> finalSlides = SlideShowOperations.sortSlideShow(slides);
        System.out.println("after sort");
        String targetFile = scanner.nextLine();
        FileOperator.writeToFile(targetFile, finalSlides.size() + "\n");
        for (Slide slide : finalSlides) {
            //System.out.println(slide.getIds());
            String ids = slide.getIds().size() == 1 ? slide.getIds().get(0) + "" : slide.getIds().get(0) + " " + slide.getIds().get(1) + "";
            FileOperator.writeToFile(targetFile, ids + "\n");
        }
    }
}
