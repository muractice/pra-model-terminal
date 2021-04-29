package domain.shipping;

import domain.shipping.evnet.ShippingRequestEvent;

public interface ShippingManagementRepository {
    public void request(ShippingRequestEvent shippingRequestEvent);
}
