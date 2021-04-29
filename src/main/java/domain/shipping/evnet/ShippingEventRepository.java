package domain.shipping.evnet;

public interface ShippingEventRepository {
    public void register(ShippingReceiptEvent shippingReceiptEvent);
    public void register(ShippingRequestEvent shippingRequestEvent);
}
