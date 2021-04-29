package domain.shipping.evnet;

import domain.shipping.details.ShippingDetails;
import domain.shipping.ShippingId;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ShippingRequestEvent {
    private final ShippingId shippingId;
    private final ShippingDetails shippingDetails;

    public static ShippingRequestEvent from(ShippingReceiptEvent shippingReceiptEvent){
        return new ShippingRequestEvent(shippingReceiptEvent.getShippingId(),
                shippingReceiptEvent.getShippingDetails());
    }
}
