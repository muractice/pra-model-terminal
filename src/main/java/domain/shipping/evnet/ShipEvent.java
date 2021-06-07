package domain.shipping.evnet;

import domain.deliverycompany.ShippedEquipmentOfDeliveryCompanyListForPackage;
import domain.shipping.ShippingId;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class ShipEvent {
    @Getter
    private final ShippingId shippingId;
    private final ShippingDate shippingDate;
    @Getter
    private final ShippedItemList shippedItemList;

}
