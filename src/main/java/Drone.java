import java.util.List;
import java.util.Map;

/**
 * Created by florent on 11/02/16.
 */
public class Drone {

    int id;
    int row;
    int col;

    List<Product> products;


    void setCoord(int[] c) {
        row = c[0];
        col = c[1];
    }


}
