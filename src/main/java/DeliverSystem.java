import com.sun.org.apache.xpath.internal.SourceTree;
import jdk.nashorn.internal.objects.annotations.Where;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Function;

/**
 * Created by florent on 11/02/16.
 */
public class DeliverSystem {

    static List<Command> deliver(Simulation sim) {

        List<Command> commands = new ArrayList<>();

        List<Order> orderedSorted = new ArrayList<>(sim.orders.values());
        Collections.sort(orderedSorted, (o1, o2) ->  o1.totalWeight - o2.totalWeight);

        mainLbl: for(Order order : orderedSorted) {

                for (int p : order.products) {
                    System.out.println("Product Id :"+p);
                    wareHouseLbl:
                    for (Warehouse w : sim.warehouses.values()) {
//                        System.out.println("Warehouse : products : "+ Arrays.toString(w.products));
                        if (w.products[p] > 0) {

                            Random random = new Random();
                            // drone le plus proche du warehouse courant
                            Drone d = closestDrone(w, sim.drones.values());
//                            Drone d = sim.drones.get(0);
//                            Drone d = sim.drones.get(random.nextInt(sim.drones.size()));

//                            int nbProducts = Math.min((sim.maxpayload / sim.products.get(p).weight));
                            int nbProducts = 1;
                            System.out.println(nbProducts);

                            long delta = (distance(new int[]{d.row, d.col}, new int[]{w.row, w.col}) + 1);
                            sim.turns -= delta;
                            if (sim.turns < 0) {
                                System.out.println("Turns over :(");
                                break mainLbl;
                            }
                            commands.add(new LoadCommand(d.id, w.id, order.id, p, nbProducts));
                            w.products[p] -= nbProducts;
                            d.row = w.row;
                            d.col = w.col;

                            delta = (distance(new int[]{d.row, d.col}, new int[]{order.row, order.col}) + 1);
                            sim.turns -= delta;
                            if (sim.turns < 0) {
                                System.out.println("Turns over :(");
                                break mainLbl;
                            }
                            commands.add(new DeliverCommand(d.id, order.id, p, nbProducts));
                            d.row = order.row;
                            d.col = order.col;
                            break wareHouseLbl;
                        }
                    }
                }

        }

        return commands;
    }

    static Drone closestDrone(Warehouse w, Collection<Drone> drones) {
        Map<Integer, Drone> distances = new HashMap<>();

        for (Drone drone: drones) {
            distances.put(distance(new int[]{drone.row, drone.col}, new int[]{w.row, w.col}), drone);
        }

        int min = distances.keySet().stream().mapToInt(x->x).min().getAsInt();

        return distances.get(min);
    }


    static int distance(int[] pointA, int[] pointB) {

        return (int)Math.ceil( //
                Math.sqrt(//
                        (Math.pow(pointB[0] - pointA[0],2)//
                         + Math.pow(pointB[1] - pointA[1],2)
                        )
                )
        );
    }

}
