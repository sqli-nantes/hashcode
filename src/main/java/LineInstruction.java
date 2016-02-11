import lombok.AllArgsConstructor;

@AllArgsConstructor
public class LineInstruction extends Instruction {


    int r1;
    int c1;
    int r2;
    int c2;

    @Override
    public String toString() {
        return String.format("PAINT_LINE %d %d %d %d", r1, c1, r2, c2);
    }
}
