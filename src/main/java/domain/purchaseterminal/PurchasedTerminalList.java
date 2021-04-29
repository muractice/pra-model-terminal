package domain.purchaseterminal;

import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class PurchasedTerminalList {

    private final List<PurchasedTerminal> purchasedTerminalList;

    public int getPurchasedTerminalNum(){
        return purchasedTerminalList.size();
    }

}
