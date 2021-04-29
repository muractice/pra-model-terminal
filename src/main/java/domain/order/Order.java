package domain.order;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Order {
    private final OrderId orderId;
    private final OrderDetails orderDetails;

    public static Order of(OrderId orderId,OrderDetails orderDetails){
        return new Order(orderId,orderDetails);
    }


}
