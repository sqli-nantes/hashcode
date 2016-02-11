/**
 * Created by florent on 11/02/16.
 */
public class DeliverCommand extends GenericCommand {


    public DeliverCommand(int droneId, int orderId, int productId, int nbProducts) {
        super(droneId, -1, orderId, productId, nbProducts);
    }

    @Override
    public String toString() {
        return droneId+" D "+orderId+" "+productId+" "+nbProducts;
    }
}


