package domain.deliverycompany;

import domain.shipping.details.Packing;

public interface DeliveryCompanyRepository {
    public void request(Packing packing);
}
