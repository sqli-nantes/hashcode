import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class CommandWriter {


    void writeTo(String filename, List<Command> commands) throws IOException {

        Path path = Paths.get(filename);
        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            writer.write(""+commands.size());
            writer.newLine();
            for(Command command : commands) {
                writer.write(""+command);
                writer.newLine();
            }
        }
    }
}
