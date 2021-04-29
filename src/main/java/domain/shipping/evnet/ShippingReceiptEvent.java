package domain.shipping.evnet;

import domain.shipping.details.ShippingDetails;
import domain.shipping.ShippingId;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class ShippingReceiptEvent {
    @Getter
    private final ShippingId shippingId;
    @Getter
    private final ShippingDetails shippingDetails;

    public static ShippingReceiptEvent of(ShippingId shippingId, ShippingDetails shippingDetails){
        return new ShippingReceiptEvent(shippingId,shippingDetails);
    }
}
