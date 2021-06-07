package service.application;

import domain.application.TerminalApplication;
import domain.order.Order;
import domain.order.OrderId;
import domain.order.OrderRepository;
import domain.shipping.ShippingManagementRepository;
import domain.shipping.details.Packing;
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
        Order order = order(terminalApplication);
        ship(terminalApplication, order);
    }

    private void stock(TerminalApplication terminalApplication){
        stock.allocate(terminalApplication.createStockRequestDetails());
    }

    private Order order(TerminalApplication terminalApplication){
        Order order = Order.of(orderRepository.allocate(),terminalApplication.createOrderDetails());
        orderRepository.register(order);
        return order;
    }

    private void ship(TerminalApplication terminalApplication, Order order){
        ShippingReceiptEvent shippingReceiptEvent = receiptShipping(terminalApplication, order);
        ShippingEntity shippingEntity = ShippingEntity.from(shippingReceiptEvent);
        ShippingEntity requestedShippingEntity = requestShipping(shippingEntity,shippingReceiptEvent);
        shippingRepository.register(requestedShippingEntity);
    }

    private ShippingReceiptEvent receiptShipping(TerminalApplication terminalApplication, Order order){
        Packing packing = terminalApplication.createShippingDetails();
        ShippingReceiptEvent shippingReceiptEvent
                = ShippingReceiptEvent.of(shippingRepository.allocate(),order.getOrderId(),packing);
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
