package domain.stock;

import domain.goods.Goods;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class StockRequestDetails {
    private final Goods goods;
    private final Number quantity = 1;

    public static StockRequestDetails of(Goods goods){
        return new StockRequestDetails(goods);
    }

}
