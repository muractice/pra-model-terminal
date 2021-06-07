package service.shipping;

import domain.order.Order;
import domain.order.OrderRepository;
import domain.shipping.ShippingEntity;
import domain.shipping.ShippingRepository;
import domain.shipping.evnet.ShipEvent;
import org.springframework.beans.factory.annotation.Autowired;

public class ShippedResultReceiveService {

    @Autowired
    ShippingRepository shippingRepository;

    @Autowired
    OrderRepository orderRepository;

    public void receive(ShipEvent shipEvent){
        ShippingEntity shippingEntity = shippingRepository.findByShippingId(shipEvent.getShippingId());
        shippingRepository.save(shippingEntity.toShipped(shipEvent));

        Order order = orderRepository.findByOrderId(shippingEntity.getOrderId());

    }
}
