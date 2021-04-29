package domain.linecontract;

import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class LineContractList {
    private final List<LineContract> lineContract;

    public int getLineContractNum(){
        return lineContract.size();
    }
}
