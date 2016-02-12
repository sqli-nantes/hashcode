import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {

        SimulationReader pr = new SimulationReader();

//        Simulation sim = pr.readFile("basic.in");
//        Simulation sim = pr.readFile("busy_day.in");
//        Simulation sim = pr.readFile("mother_of_all_warehouses.in");
        Simulation sim = pr.readFile("redundancy.in");

        System.out.println(sim);

        List<Command> commands = DeliverSystem.deliver(sim);




        System.out.println(commands.size());
        // a partir du painting, je sors les instructions.
        CommandWriter iw = new CommandWriter();
        iw.writeTo("out.txt", commands);

//        ShapeExtractor se = new ShapeExtractor(p);
//        se.extractShapes();
//        se.shapes.stream().forEach(x -> {
//                System.out.println(x.height());
//                System.out.println(x.width());
//                System.out.println(x);});
//
//
//        for(Shape shape : se.shapes) {
//            ShapePainter po = new ShapePainter();
//            List<Instruction> instructions = po.optimize(shape);
//
//            System.out.println(instructions);
//        }


//        System.out.println(instructions.size());
//        // a partir du painting, je sors les instructions.
//        InstructionWriter iw = new InstructionWriter();
//        iw.writeTo("out.txt", instructions);

    }




}
