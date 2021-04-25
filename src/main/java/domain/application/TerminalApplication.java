package domain.application;

import domain.contract.ContractId;
import domain.order.OrderDate;
import domain.product.Terminal;
import domain.shipping.ShippingAddress;
import domain.shipping.ShippingName;
import domain.shipping.ShippingRequestDetails;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class TerminalApplication {
    @Getter
    private final ContractId contractId;
    @Getter
    private final Terminal terminal;
    @Getter
    private final OrderDate orderDate;
    @Getter
    private final ShippingName shippingName;
    @Getter
    private final ShippingAddress shippingAddress;

    static TerminalApplication of(Terminal terminal,
                                  ContractId contractId,
                                  OrderDate orderDate,
                                  ShippingName shippingName,
                                  ShippingAddress shippingAddress){
        return new TerminalApplication(contractId,terminal,orderDate,
                shippingName,shippingAddress);
    }

    public ShippingRequestDetails createShippingRequestDetails(){
        return ShippingRequestDetails.of(terminal,shippingName,shippingAddress);
    }
}
