package domain.deliverycompany;

import lombok.AllArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
public class ShippedEquipmentOfDeliveryCompanyListForPackage {
    private final List<ShippedEquipmentOfDeliveryCompany> equipmentList;

    public ShippedDateOfDeliveryCompany getShippedDateOfDeliveryCompany(){
        return new ShippedDateOfDeliveryCompany(LocalDate.now());
    }

}
