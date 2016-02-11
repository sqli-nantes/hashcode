import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by florent on 11/02/16.
 */
public class DeliverSystem {

    static List<Command> deliver(Simulation sim) {

        List<Command> commands = new ArrayList<>();


        Drone d = sim.drones.get(0);

        mainLbl: for(Order order : sim.orders.values()) {

            /*if(order.totalWeight <= sim.maxpayload) {
                for (int p : order.products){
                    wareHouseLbl: for (Warehouse w : sim.warehouses.values()){
                        if (w.products[p] > 0){
                            int nbProducts = 1;
                            long delta = (distance(new int[]{d.row, d.col}, new int[]{w.row, w.col}) + 1);
                            sim.turns -= delta;
                            if (sim.turns < 0){
                                System.out.println("Truns over :(");
                                break mainLbl;
                            }
                            commands.add(new LoadCommand(d.id,w.id,order.id, p, nbProducts));
                            w.products[p]-=nbProducts;
                            d.row = w.row;
                            d.col = w.col;
                        }
                        break wareHouseLbl;
                    }
                }
                for (int p : order.products){
                    int nbProducts = 1;
                    long delta = (distance(new int[]{d.row, d.col}, new int[]{order.row, order.col}) + 1);
                    sim.turns -= delta;
                    if (sim.turns < 0){
                        System.out.println("Truns over :(");
                        break mainLbl;
                    }
                    commands.add(new DeliverCommand(d.id,order.id, p, nbProducts));
                    d.row = order.row;
                    d.col = order.col;
                }

            }else{*/
                for (int p : order.products) {
                    System.out.println("Product Id :"+p);
                    wareHouseLbl:
                    for (Warehouse w : sim.warehouses.values()) {
//                        System.out.println("Warehouse : products : "+ Arrays.toString(w.products));
                        if (w.products[p] > 0) {
                            int nbProducts = 1;
                            long delta = (distance(new int[]{d.row, d.col}, new int[]{w.row, w.col}) + 1);
                            sim.turns -= delta;
                            if (sim.turns < 0) {
                                break mainLbl;
                            }
                            commands.add(new LoadCommand(d.id, w.id, order.id, p, nbProducts));
                            w.products[p] -= nbProducts;
                            d.row = w.row;
                            d.col = w.col;

                            delta = (distance(new int[]{d.row, d.col}, new int[]{order.row, order.col}) + 1);
                            sim.turns -= delta;
                            if (sim.turns < 0) {
                                System.out.println("Truns over :(");
                                break mainLbl;
                            }
                            commands.add(new DeliverCommand(d.id, order.id, p, nbProducts));
                            d.row = order.row;
                            d.col = order.col;
                            break wareHouseLbl;
                        }
                    }
                }
            //}




        }



        return commands;
    }



    static long distance(int[] pointA, int[] pointB){
        return Math.round( //
                Math.sqrt(//
                        (Math.pow(pointB[0] - pointA[0],2)//
                         + Math.pow(pointB[1] - pointA[1],2)
                        )
                )
        );
    }

}
