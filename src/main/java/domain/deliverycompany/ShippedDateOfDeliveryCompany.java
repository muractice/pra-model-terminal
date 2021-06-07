package domain.deliverycompany;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@AllArgsConstructor
public class ShippedDateOfDeliveryCompany {
    @Getter
    private final LocalDate value;
}
