package domain.equipment;

import domain.contract.Contract;
import domain.shipping.evnet.SerialNumber;
import domain.shipping.evnet.ShipEvent;
import domain.shipping.evnet.ShippedItem;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
public class RegisterEquipmentEventList {
    @Getter
    private final List<RegisterEquipmentEvent> registerEquipmentEventList;

    public static RegisterEquipmentEventList from(Contract contract, ShipEvent shipEvent){

        List<RegisterEquipmentEvent> registerEquipmentEventList =
        shipEvent.getShippedItemList().getShippedItems().stream()
                .map(shippedItem -> {return RegisterEquipmentEvent.of(contract,shippedItem.getSerialNumber());} )
                .collect(Collectors.toList());

        return new RegisterEquipmentEventList(registerEquipmentEventList);
    }
}
