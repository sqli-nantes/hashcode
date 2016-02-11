import java.util.Arrays;

/**
 * Created by florent on 11/02/16.
 */
public class Warehouse {

    int id;
    int row;
    int col;

    int[] products;

    Warehouse(int size) {
        products = new int[size];
    }

    void setCoord(int[] c) {
        row = c[0];
        col = c[1];
    }

    void setProduct(int[] nbproduct) {
        for(int i =0; i <nbproduct.length; i++){
            products[i] = nbproduct[i];
        }
    }

    @Override
    public String toString() {
        return "Warehouse{" +
                "id=" + id +
                ", row=" + row +
                ", col=" + col +
                ", products=" + Arrays.toString(products) +
                '}';
    }
}
