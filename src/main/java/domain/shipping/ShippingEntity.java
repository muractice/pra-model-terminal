package domain.shipping;

import domain.shipping.evnet.ShippingEvent;
import domain.shipping.evnet.ShippingReceiptEvent;
import domain.shipping.evnet.ShippingRequestEvent;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ShippingEntity {

    private final ShippingId shippingId;
    private final ShippingStatus shippingStatus;

    public static ShippingEntity from(ShippingReceiptEvent shippingReceiptEvent){
        return new ShippingEntity(shippingReceiptEvent.getShippingId(),ShippingStatus.WAITING);
    }

    public ShippingEntity toRequested(ShippingRequestEvent shippingRequestEvent){
        return new ShippingEntity(shippingId,ShippingStatus.REQUESTED);
    }

}
