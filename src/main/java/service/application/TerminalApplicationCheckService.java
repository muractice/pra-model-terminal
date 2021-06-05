package service.application;

import domain.TerminalApplicationPolicy;
import domain.application.TerminalApplication;
import domain.contract.ContractId;
import domain.contract.ContractRepository;
import domain.linecontract.LineContractRepository;
import domain.purchaseterminal.PurchasedTerminalRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class TerminalApplicationCheckService {
    @Autowired
    ContractRepository contractRepository;
    @Autowired
    LineContractRepository lineContractRepository;
    @Autowired
    PurchasedTerminalRepository purchasedTerminalRepository;

    public boolean check(TerminalApplication terminalApplication){
        ContractId contractId = terminalApplication.getContractId();
        return TerminalApplicationPolicy.check(
                contractRepository.findByContractId(contractId),
                lineContractRepository.findByContractId(contractId),
                purchasedTerminalRepository.findByContractId(contractId)
        );
    }
}
