package domain.equipment;

import domain.contract.ContractId;
import domain.shipping.evnet.SerialNumber;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class EquipmentEntity {
    private final SerialNumber serialNumber;
    private final ContractId contractId;
    private final EquipmentStatus equipmentStatus;

    public static EquipmentEntity from(RegisterEquipmentEvent registerEquipmentEvent){
        return new EquipmentEntity(registerEquipmentEvent.getSerialNumber()
                ,registerEquipmentEvent.getContractId()
                ,EquipmentStatus.CONTRACTED);
    }
}
