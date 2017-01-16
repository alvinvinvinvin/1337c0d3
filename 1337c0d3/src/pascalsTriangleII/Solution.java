package pascalsTriangleII;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> output = new ArrayList<Integer>();
        if(rowIndex<0) return output;
        output.add(1);
        for(int i = 1; i < rowIndex + 1; i++){
            for(int j = i - 1; j > 0; j--){
                int tmp = output.get(j-1)+output.get(j);
                output.set(j,tmp);
            }
            output.add(1);
        }
        return output;
    }
}
