package domain.order;

public interface OrderRepository {
    public OrderId allocate();
    public void register(Order order);
    public Order findByOrderId(OrderId orderId);
}
