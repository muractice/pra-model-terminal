package domain.order;

import domain.contract.ContractId;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class Order {
    @Getter
    private final OrderId orderId;
    private final OrderDetails orderDetails;

    public static Order of(OrderId orderId,OrderDetails orderDetails){
        return new Order(orderId,orderDetails);
    }

    public ContractId getContractId(){
        return orderDetails.getContractId();
    }

}
