package domain.shipping.evnet;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;

@AllArgsConstructor
public class ShippedItem {
    @Getter
    private final SerialNumber serialNumber;
    private final EquipmentModel equipmentModel;
}
