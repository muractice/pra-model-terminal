package service.shipping;

import domain.contract.Contract;
import domain.contract.ContractRepository;
import domain.order.Order;
import domain.order.OrderRepository;
import domain.shipping.ShippingEntity;
import domain.shipping.ShippingRepository;
import domain.shipping.evnet.ShipEvent;
import domain.shipping.evnet.ShippingEventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import service.equipment.EquipmentRegisterService;

public class ShippedResultReceiveService {

    @Autowired
    ShippingEventRepository shippingEventRepository;

    @Autowired
    ShippingRepository shippingRepository;

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    ContractRepository contractRepository;

    @Autowired
    EquipmentRegisterService equipmentRegisterService;

    public void receive(ShipEvent shipEvent){

        ShippingEntity shippingEntity = shippingRepository.findByShippingId(shipEvent.getShippingId());
        shippingEventRepository.register(shipEvent);
        shippingRepository.save(shippingEntity.toShipped(shipEvent));

        Order order = orderRepository.findByOrderId(shippingEntity.getOrderId());
        Contract contract = contractRepository.findByContractId(order.getContractId());

        equipmentRegisterService.register(contract,shipEvent);

    }
}
