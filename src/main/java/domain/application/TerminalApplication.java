package domain.application;

import domain.contract.ContractId;
import domain.goods.MethodOfPayment;
import domain.order.OrderDate;
import domain.order.OrderDetails;
import domain.goods.Terminal;
import domain.shipping.details.ShippingAddress;
import domain.shipping.details.Packing;
import domain.shipping.details.ShippingName;
import domain.stock.StockRequestDetails;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class TerminalApplication {
    @Getter
    private final ContractId contractId;
    @Getter
    private final Terminal terminal;

    private final MethodOfPayment methodOfPayment;
    @Getter
    private final OrderDate orderDate;
    @Getter
    private final ShippingName shippingName;
    @Getter
    private final ShippingAddress shippingAddress;

    static TerminalApplication of(ContractId contractId,
                                  Terminal terminal,
                                  MethodOfPayment methodOfPayment,
                                  OrderDate orderDate,
                                  ShippingName shippingName,
                                  ShippingAddress shippingAddress){
        return new TerminalApplication(contractId,terminal,methodOfPayment,orderDate,
                shippingName,shippingAddress);
    }

    public OrderDetails createOrderDetails(){
        return new OrderDetails(contractId,terminal,methodOfPayment,orderDate);
    }

    public Packing createShippingDetails(){
        return Packing.of(terminal,shippingName,shippingAddress);
    }

    public StockRequestDetails createStockRequestDetails(){
        return StockRequestDetails.of(terminal);
    }

}
