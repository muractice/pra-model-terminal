package domain.shipping.evnet;

import domain.deliverycompany.ShippedDateOfDeliveryCompany;
import lombok.AllArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
public class ShippingDate {
    private final LocalDate value;

    public static ShippingDate from(ShippedDateOfDeliveryCompany shippedDateOfDeliveryCompany){
        return new ShippingDate(shippedDateOfDeliveryCompany.getValue());
    }
}
