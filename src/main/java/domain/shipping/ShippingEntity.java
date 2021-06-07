package domain.shipping;

import domain.order.OrderId;
import domain.shipping.evnet.ShipEvent;
import domain.shipping.evnet.ShippingReceiptEvent;
import domain.shipping.evnet.ShippingRequestEvent;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class ShippingEntity {

    private final ShippingId shippingId;
    @Getter
    private final OrderId orderId;
//    todo:packingIdを追加するよ
    private final ShippingStatus shippingStatus;

    public static ShippingEntity from(ShippingReceiptEvent shippingReceiptEvent){
        return new ShippingEntity(shippingReceiptEvent.getShippingId(),shippingReceiptEvent.getOrderId(),ShippingStatus.WAITING);
    }
    public ShippingEntity toRequested(ShippingRequestEvent shippingRequestEvent){
        return new ShippingEntity(shippingId,orderId,ShippingStatus.REQUESTED);
    }
    public ShippingEntity toShipped(ShipEvent shipEvent){
        return new ShippingEntity(shippingId,orderId,ShippingStatus.SHIPPED);
    }
}
