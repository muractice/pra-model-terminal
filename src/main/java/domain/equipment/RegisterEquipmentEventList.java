package domain.equipment;

import domain.contract.Contract;
import domain.shipping.evnet.SerialNumber;
import domain.shipping.evnet.ShipEvent;
import domain.shipping.evnet.ShippedItem;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
public class RegisterEquipmentEventList {
    private final List<RegisterEquipmentEvent> registerEquipmentEventList;

    public static RegisterEquipmentEventList from(Contract contract, ShipEvent shipEvent){
        
        List<SerialNumber> serialNumbers =
        shipEvent.getShippedItemList().getShippedItems().stream().map(ShippedItem::getSerialNumber)
                .collect(Collectors.toList());
        List<RegisterEquipmentEvent> registerEquipmentEventList = serialNumbers.stream()
                .map(s -> {
                    return RegisterEquipmentEvent.of(contract, s);
                }).collect(Collectors.toList());

        return new RegisterEquipmentEventList(registerEquipmentEventList);
    }
}
