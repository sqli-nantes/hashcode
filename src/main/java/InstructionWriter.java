import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class InstructionWriter {


    void writeTo(String filename, List<Instruction> instructions) throws IOException {

        Path path = Paths.get(filename);
        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            writer.write(""+instructions.size());
            writer.newLine();
            for(Instruction instruction : instructions) {
                writer.write(""+instruction);
                writer.newLine();
            }
        }
    }
}
