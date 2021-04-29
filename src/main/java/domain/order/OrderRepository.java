package domain.order;

public interface OrderRepository {
    public OrderId allocate();
    public void register(Order order);
}
