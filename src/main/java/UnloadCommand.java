/**
 * Created by florent on 11/02/16.
 */
public class UnloadCommand extends GenericCommand {

    public UnloadCommand(int droneId, int warehouseId, int orderId, int productId, int nbProducts) {
        super(droneId, warehouseId, orderId, productId, nbProducts);
    }

    @Override
    public String toString() {
        return droneId+" U "+orderId+" "+productId+" "+nbProducts;
    }
}


