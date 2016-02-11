/**
 * Created by florent on 11/02/16.
 */
public class GenericCommand extends Command {

    int warehouseId;
    int orderId;
    int productId;
    int nbProducts;

    public GenericCommand(int droneId, int warehouseId, int orderId, int productId, int nbProducts) {
        super(droneId);
        this.warehouseId = warehouseId;
        this.orderId = orderId;
        this.productId = productId;
        this.nbProducts = nbProducts;
    }

    @Override
    public String toString() {
        return "LoadCommand{}";
    }
}
