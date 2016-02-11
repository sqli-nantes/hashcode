/**
 * Created by florent on 11/02/16.
 */
public class LoadCommand extends GenericCommand {

    public LoadCommand(int droneId, int warehouseId, int orderId, int productId, int nbProducts) {
        super(droneId, warehouseId, orderId, productId, nbProducts);
    }

    @Override
    public String toString() {
        return droneId+" L "+warehouseId+" "+productId+" "+nbProducts;
    }
}


