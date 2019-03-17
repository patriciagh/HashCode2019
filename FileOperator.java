import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;
import java.util.stream.Collectors;

public class FileOperator {
    public static List<Photo> readFromFile(String path) throws IOException {
        List<Photo> photos = new ArrayList<>();
        List<String> lines = Files.lines(Paths.get(path)).collect(Collectors.toList());
        for (int i = 1; i < lines.size(); i++) {
            String[] currentPhotos = lines.get(i).split(" ");
            char photoType = currentPhotos[0].charAt(0);
            int numberOfTags = Integer.parseInt(currentPhotos[1]);
            List<String> tags = new ArrayList<>();
            for (int j = 2; j < currentPhotos.length; j++) {
                tags.add(currentPhotos[j]);
            }
            Photo currentPhoto = new Photo(i - 1, photoType, numberOfTags, tags);
            photos.add(currentPhoto);
        }
        return photos;
    }

    public static void writeToFile(String filePath, String... messages) throws IOException {
        for (String message : messages) {
            Files.write(Paths.get(filePath), message.toString().getBytes(), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        }
    }

    public static void main(String[] args) throws IOException {
        List<Photo> photos = readFromFile("D:\\Downloads\\a_example.txt");
        for (Photo photo : photos) {
            String photoType = photo.getType() == 'H' ? "horizontal" : "vertical";
            System.out.println("Photo " + photo.getId() + " " + photoType + " and has tags " + photo.getTags());
        }
    }
}
