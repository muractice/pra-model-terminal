package domain.contract;

public interface ContractRepository {
    public Contract findByContractId(ContractId contractId);
}
