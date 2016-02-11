import lombok.AllArgsConstructor;

import java.nio.MappedByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by florent on 11/02/16.
 */
public class Simulation {

    int rows;
    int columns;
    int turns;
    int maxpayload;

    Map<Integer, Product> products;
    Map<Integer, Warehouse> warehouses;
    Map<Integer, Order> orders;
    Map<Integer, Drone> drones;

    Simulation(){
        products = new HashMap<>();
        warehouses = new HashMap<>();
        orders = new HashMap<>();
    }

    void setProducts(int[] weights) {
        for(int i=0;i< weights.length ; i++) {
            Product p = new Product();
            p.id = i;
            p.weight = weights[i];
            products.put(i, p);
        }
    }

    void setVals(int[] vals) {

        rows = vals[0];
        columns = vals[1];
        drones = new HashMap<>();
        for (int i = 0; i < vals[2]; i++){
            Drone d = new Drone();
            d.id = i;
            d.col = 0;
            d.row = 0;
            drones.put(i,d);
        }
        turns = vals[3];
        maxpayload = vals[4];
    }



    @Override
    public String toString() {
        return "Simulation{" +
                "rows=" + rows +
                ", columns=" + columns +
                ", drones=" + drones +
                ", turns=" + turns +
                ", maxpayload=" + maxpayload +
                ", products=" + products +
                ", warehouses=" + warehouses +
                ", orders=" + orders +
                '}';
    }

}
