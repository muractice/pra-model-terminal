package domain.shipping;

public interface ShippingRepository {
    public ShippingId allocate();
    public void register(ShippingEntity shippingEntity);
    public void save(ShippingEntity shippingEntity);
}
