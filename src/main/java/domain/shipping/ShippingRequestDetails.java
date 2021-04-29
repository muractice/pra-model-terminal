package domain.shipping;

import domain.goods.Terminal;
import domain.shipping.details.ShippingAddress;
import domain.shipping.details.ShippingName;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ShippingRequestDetails {
    private final Terminal terminal;
    private final ShippingName shippingName;
    private final ShippingAddress shippingAddress;

    public static ShippingRequestDetails of(Terminal terminal,ShippingName shippingName, ShippingAddress shippingAddress)
    {
        return new ShippingRequestDetails(terminal,shippingName,shippingAddress);
    }

}
