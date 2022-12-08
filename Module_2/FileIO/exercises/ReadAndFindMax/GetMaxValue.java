package ReadAndFindMax;

import java.util.List;

public class GetMaxValue {
    public int getMaxValue(List<Integer> integerList) {
        int max = integerList.get(0);
        int counnt=0;
        while (counnt<integerList.size()){
            if (integerList.get(counnt)>max) max=integerList.get(counnt);
            counnt++;
        }
        return max;
    }
}
