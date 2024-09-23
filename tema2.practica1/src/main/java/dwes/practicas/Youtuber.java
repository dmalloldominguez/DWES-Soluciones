package dwes.practicas;

import java.time.LocalDate;
import java.util.Date;

public record Youtuber(String name, LocalDate startDate, int subscribers, int views) {
    @Override
    public String toString() {
        return "Youtuber{" +
                "name='" + name + '\'' +
                ", startDate=" + startDate +
                ", subscribers=" + subscribers +
                ", views=" + views +
                '}';
    }
}
