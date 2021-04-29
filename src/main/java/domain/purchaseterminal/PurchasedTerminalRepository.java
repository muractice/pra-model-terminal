package domain.purchaseterminal;

import domain.contract.ContractId;

public interface PurchasedTerminalRepository {
    public PurchasedTerminalList findByContractId(ContractId contractId);
}
