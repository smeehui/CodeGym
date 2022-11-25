package huy.code;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] intList = {3,5,2,8,3,8,6,9,5,2};
//        sortByLoop(intList);
        sortByRecursive(intList,0,intList.length-1);
        System.out.println(Arrays.toString(intList));

    }

    private static int[] sortByRecursive(int[] intList, int index,int oldRange) {
        if(oldRange==0) return intList;
        if (index == oldRange){
            return sortByRecursive(intList,0,--oldRange);
        }
            if (intList[index] > intList[index + 1]) {
                int temp = intList[index];
                intList[index] = intList[index + 1];
                intList[index + 1] = temp;
            }
        return sortByRecursive(intList, index + 1,oldRange);
    }

    private static void sortByLoop(int[] intList) {

        for (int i = 0; i < intList.length; i++){
            for (int j = 0; j < intList.length-i-1; j++){
                if (intList[j] >intList[j+1]){
                    int temp = intList[j];
                    intList[j] = intList[j+1];
                    intList[j+1] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(intList));
    }
}