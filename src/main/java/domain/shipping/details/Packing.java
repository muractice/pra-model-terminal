package domain.shipping.details;

import domain.goods.Goods;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Packing {
    private final Goods goods;
    private final ShippingName shippingName;
    private final ShippingAddress shippingAddress;

    public static Packing of(Goods goods, ShippingName shippingName, ShippingAddress shippingAddress){
        return new Packing(goods,shippingName,shippingAddress);
    }
}
