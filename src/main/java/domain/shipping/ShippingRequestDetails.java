package domain.shipping;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ShippingRequestDetails {
    private final ShippingItem shippingItem;
    private final ShippingName shippingName;
    private final ShippingAddress shippingAddress;

    public static ShippingRequestDetails of(ShippingItem shippingItem,ShippingName shippingName, ShippingAddress shippingAddress)
    {
        return new ShippingRequestDetails(shippingItem,shippingName,shippingAddress);
    }

}
