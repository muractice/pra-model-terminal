package domain.shipping.evnet;

import domain.order.OrderId;
import domain.shipping.details.Packing;
import domain.shipping.ShippingId;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class ShippingReceiptEvent {
    @Getter
    private final ShippingId shippingId;
    @Getter
    private final OrderId orderId;
    @Getter
    private final Packing packing;

    public static ShippingReceiptEvent of(ShippingId shippingId, OrderId orderId, Packing packing){
        return new ShippingReceiptEvent(shippingId, orderId, packing);
    }
}
