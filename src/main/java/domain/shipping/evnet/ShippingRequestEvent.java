package domain.shipping.evnet;

import domain.shipping.details.Packing;
import domain.shipping.ShippingId;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ShippingRequestEvent {
    private final ShippingId shippingId;
    private final Packing packing;

    public static ShippingRequestEvent from(ShippingReceiptEvent shippingReceiptEvent){
        return new ShippingRequestEvent(shippingReceiptEvent.getShippingId(),
                shippingReceiptEvent.getPacking());
    }
}
