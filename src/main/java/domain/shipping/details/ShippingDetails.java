package domain.shipping.details;

import domain.goods.Goods;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ShippingDetails {
    private final Goods goods;
    private final ShippingName shippingName;
    private final ShippingAddress shippingAddress;

    public static ShippingDetails of(Goods goods,ShippingName shippingName, ShippingAddress shippingAddress){
        return new ShippingDetails(goods,shippingName,shippingAddress);
    }
}
