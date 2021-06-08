package domain.equipment;

import domain.contract.Contract;
import domain.contract.ContractId;
import domain.shipping.evnet.EquipmentModel;
import domain.shipping.evnet.SerialNumber;
import domain.shipping.evnet.ShipEvent;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class RegisterEquipmentEvent {
    @Getter
    private final ContractId contractId;
    @Getter
    private final SerialNumber serialNumber;

    public static RegisterEquipmentEvent of(Contract contract, SerialNumber serialNumber){
        return new RegisterEquipmentEvent(contract.getContractId(),serialNumber);
    }

}
