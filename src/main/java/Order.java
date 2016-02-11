import java.util.Arrays;
import java.util.List;

/**
 * Created by florent on 11/02/16.
 */
public class Order {

    Simulation sim;
    int id; // = customer
    int row;
    int col;
    int[] products;
    int totalWeight;

    Order(Simulation sim) {
        this.sim = sim;
    }

    void setCoord(int[] c) {
        row = c[0];
        col = c[1];
    }

    void setProducts(int[] vals) {
        products = vals;
        totalWeight = 0;
        for(int i : products) {
            totalWeight += sim.products.get(i).weight;
        }
    }



    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", row=" + row +
                ", col=" + col +
                ", products=" + Arrays.toString(products) +
                '}';
    }
}
