
public class DotInstruction extends Instruction {

    int r;
    int c;
    int radius;

    DotInstruction(int r, int c, int radius) {
        this.r = r;
        this.c = c;
        this.radius = radius;
    }

    @Override
    public String toString() {
        return String.format("PAINT_SQUARE %d %d %d", r, c, radius);
    }
}
