import java.util.ArrayList;
import java.util.List;

public class ShapePainter {

    List<Instruction> optimize(Shape s) {
        List<Instruction> result = new ArrayList<>();

        if(s.height() == 1 && s.width() == 1) {
            result.add(new DotInstruction(s.lefter().r, s.lefter().c, 0));
            return result;
        }
        // cas faciles
        if(s.height() == 1) {
            result.add(new LineInstruction(s.lefter().r, s.lefter().c, s.righter().r, s.righter().c));
            return result;
        }
        if(s.width() == 1) {
            result.add(new LineInstruction(s.higher().r, s.higher().c, s.lower().r, s.lower().c));
            return result;
        }

        return result;
    }


}
