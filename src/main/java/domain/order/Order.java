package domain.order;

import domain.application.TerminalApplication;
import domain.contract.ContractId;
import domain.product.Terminal;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Order {
    private final OrderId orderId;
    private final ContractId contractId;
    private final Terminal terminal;
    private final OrderDate orderDate;

//    static Order from(TerminalApplication terminalApplication){
//        return new Order(
//                terminalApplication.getContractId(),
//                terminalApplication.getTerminal(),
//                terminalApplication.getOrderDate()
//                );
//    }

    public static Order of(OrderId orderId,ContractId contractId,Terminal terminal,OrderDate orderDate){
        return new Order(orderId,contractId,terminal,orderDate);
    }



}
