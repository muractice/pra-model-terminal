package domain.stock;

import domain.product.Terminal;
import domain.application.TerminalApplication;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class StockRequestDetails {
    private final Terminal terminal;
    private final Number quantity = 1;

    static StockRequestDetails from(TerminalApplication terminalApplication){
        return new StockRequestDetails(terminalApplication.getTerminal());
    }

}
