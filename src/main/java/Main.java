import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {

        PaintingReader pr = new PaintingReader();

        Painting p = pr.readFile("test.in");


        // découpe le proiblèmes : des formes à partir à partir desquelles on va savoir
        // si on applique des trucs ou pas.
        ShapeExtractor se = new ShapeExtractor(p);
        se.extractShapes();
        se.shapes.stream().forEach(x -> {
                System.out.println(x.height());
                System.out.println(x.width());
                System.out.println(x);});


        for(Shape shape : se.shapes) {
            ShapePainter po = new ShapePainter();
            List<Instruction> instructions = po.optimize(shape);

            System.out.println(instructions);
        }



//        System.out.println(instructions.size());
//        // a partir du painting, je sors les instructions.
//        InstructionWriter iw = new InstructionWriter();
//        iw.writeTo("out.txt", instructions);

    }




}
