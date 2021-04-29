package domain.order;

import domain.contract.ContractId;
import domain.goods.MethodOfPayment;
import domain.goods.Terminal;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class OrderDetails {
    private final ContractId contractId;
    private final Terminal terminal;
    private final MethodOfPayment methodOfPayment;
    private final OrderDate orderDate;

    public static OrderDetails of(ContractId contractId, Terminal terminal, MethodOfPayment methodOfPayment,OrderDate orderDate) {
        return new OrderDetails(contractId, terminal, methodOfPayment,orderDate);
    }
}