package domain.shipping.evnet;

import domain.deliverycompany.ShippedEquipmentOfDeliveryCompanyListForPackage;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
public class ShippedItemList {
    @Getter
    private final List<ShippedItem> shippedItems;

//    public static ShippedItemList from(ShippedEquipmentOfDeliveryCompanyListForPackage equipmentList){
//
//    }
}
