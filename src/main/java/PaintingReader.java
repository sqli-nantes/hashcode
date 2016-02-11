import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

public class PaintingReader {


    Painting readFile(String filename) throws IOException, URISyntaxException {
        URL url = getClass().getClassLoader().getResource(filename);
        Path p = Paths.get(url.toURI());

        Painting painting = new Painting();

        Files.lines(p).limit(1).forEach(x-> {
            painting.setDimensions(splitLineAsIntArray(x));
        });

        AtomicInteger index = new AtomicInteger();

        Files.lines(p).skip(1).forEach(x -> {
            painting.setLine(splitLineAsBooleanArray(x), index.getAndIncrement());
        });

        return painting;
    }

    static int[] splitLineAsIntArray(String line) {
        return Stream.of(line.split(" ")).mapToInt(Integer::parseInt).toArray();
    }

    static char[] splitLineAsBooleanArray(String line) {
        return line.toCharArray();
    }


}
