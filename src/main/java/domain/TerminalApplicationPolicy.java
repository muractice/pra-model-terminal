package domain;

import domain.contract.Contract;
import domain.linecontract.LineContractList;
import domain.purchaseterminal.PurchasedTerminalList;

public class TerminalApplicationPolicy {
    public static boolean check(Contract contract,LineContractList lineContractList, PurchasedTerminalList purchasedTerminalList){
        if(lineContractList.getLineContractNum() > purchasedTerminalList.getPurchasedTerminalNum() -1) return false;

        return true;
    }
}
