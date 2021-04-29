package domain.linecontract;

import domain.contract.ContractId;

public interface LineContractRepository {
    public LineContractList findByContractId(ContractId contractId);
}
