package domain.shipping.evnet;

import domain.shipping.details.ShippingDetails;
import domain.shipping.ShippingId;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ShippingEvent {
    private final ShippingId shippingId;
    private final ShippingDetails shippingDetails;

}
