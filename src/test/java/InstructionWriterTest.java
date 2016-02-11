import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class InstructionWriterTest {

    @Test
    public void test1() throws Exception {
        InstructionWriter writer = new InstructionWriter();

        writer.writeTo("out.txt", new ArrayList<>());
    }
}
