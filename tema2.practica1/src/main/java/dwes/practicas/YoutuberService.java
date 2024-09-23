package dwes.practicas;

import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class YoutuberService {
    private static final String COMMA_DELIMITER = ",";
    private List<Youtuber> youtubers;

    public YoutuberService() {
        this(Path.of("src", "main", "resources", "youtubers.csv"));
    }

    public YoutuberService(Path youtubersFile) {
        try (Stream<String> fileContent = Files.lines(youtubersFile)) {
            parseYoutubers(fileContent);
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }

    public void parseYoutubers(Stream<String> fileContent) {
        youtubers = fileContent.map(l -> Arrays.asList(l.split(COMMA_DELIMITER)))
                    .map(l -> new Youtuber(l.get(0), LocalDate.parse(l.get(1)), Integer.parseInt(l.get(2)), Integer.parseInt(l.get(3)))).toList();
    }

    public List<Youtuber> getYoutubers() {
        return youtubers;
    }
}