package domain.equipment;

import domain.shipping.evnet.EquipmentModel;
import domain.shipping.evnet.SerialNumber;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class EquipmentDetails {
    private final SerialNumber serialNumber;
    private final EquipmentModel equipmentModel;

    public static EquipmentDetails of(SerialNumber serialNumber, EquipmentModel equipmentModel){
        return new EquipmentDetails(serialNumber,equipmentModel);
    }

}
