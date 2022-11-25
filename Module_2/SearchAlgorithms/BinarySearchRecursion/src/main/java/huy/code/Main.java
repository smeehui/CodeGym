package huy.code;

import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        int [] integerList = {1,3,4,1,3,5,7,8,3,4,6,8};
        HashSet<Integer> set = new HashSet<>();
        for (int i :
                integerList) {
            set.add(i);
        }
        int [] sortedArr = new int[set.size()];
        for (int i = 0;i < sortedArr.length;i++){
            sortedArr[i] = (int) set.toArray()[i];
        }
        System.out.println(binarySearchByRecursion(sortedArr,0,sortedArr.length-1,7));
    }

    private static int binarySearchByRecursion(int[] set, int left, int right,int value) {
        if (set.length == 0) {
            System.out.println("Set is empty");
            return -1;
        }
        int mid = (left + right)/2;
        if (left>right) return -1;
        if (set[mid]<value) return binarySearchByRecursion(set,mid+1,right,value);
        else if (set[mid]>value) return binarySearchByRecursion(set,left,mid-1,value);
        else if (set[mid]==value)return mid;
        return mid;
    }
}