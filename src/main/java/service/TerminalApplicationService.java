package service;

import domain.application.TerminalApplication;
import domain.order.Order;
import domain.order.OrderRepository;
import domain.shipping.ShippingManagementRepository;
import domain.shipping.details.ShippingDetails;
import domain.shipping.ShippingEntity;
import domain.shipping.ShippingRepository;
import domain.shipping.evnet.ShippingEventRepository;
import domain.shipping.evnet.ShippingReceiptEvent;
import domain.shipping.evnet.ShippingRequestEvent;
import domain.stock.Stock;
import org.springframework.beans.factory.annotation.Autowired;

public class TerminalApplicationService {

    @Autowired
    OrderRepository orderRepository;
    @Autowired
    ShippingRepository shippingRepository;
    @Autowired
    ShippingEventRepository shippingEventRepository;
    @Autowired
    ShippingManagementRepository shippingManagementRepository;
    @Autowired
    Stock stock;
    @Autowired
    TerminalApplicationCheckService terminalApplicationCheckService;

    public void receipt(TerminalApplication terminalApplication){
        if (!terminalApplicationCheckService.check(terminalApplication)) return ;
        stock(terminalApplication);
        order(terminalApplication);
        ship(terminalApplication);
    }

    private void stock(TerminalApplication terminalApplication){
        stock.allocate(terminalApplication.createStockRequestDetails());
    }

    private void order(TerminalApplication terminalApplication){
        Order order = Order.of(orderRepository.allocate(),terminalApplication.createOrderDetails());
        orderRepository.register(order);
    }

    private void ship(TerminalApplication terminalApplication){
        ShippingReceiptEvent shippingReceiptEvent = receiptShipping(terminalApplication);
        ShippingEntity shippingEntity = ShippingEntity.from(shippingReceiptEvent);
        ShippingEntity requestedShippingEntity = requestShipping(shippingEntity,shippingReceiptEvent);
        shippingRepository.register(requestedShippingEntity);
    }

    private ShippingReceiptEvent receiptShipping(TerminalApplication terminalApplication){
        ShippingDetails shippingDetails = terminalApplication.createShippingDetails();
        ShippingReceiptEvent shippingReceiptEvent
                = ShippingReceiptEvent.of(shippingRepository.allocate(), shippingDetails);
        shippingEventRepository.register(shippingReceiptEvent);
        return shippingReceiptEvent;
    }

    private ShippingEntity requestShipping(ShippingEntity shippingEntity,ShippingReceiptEvent shippingReceiptEvent){
        ShippingRequestEvent shippingRequestEvent = ShippingRequestEvent.from(shippingReceiptEvent);
        shippingEntity.toRequested(shippingRequestEvent);
        shippingEventRepository.register(shippingRequestEvent);
        shippingManagementRepository.request(shippingRequestEvent);
        return shippingEntity;
    }
}
