package Search;

import java.util.Arrays;

public class BinarySearch {
    public static void main(String[] args) {
        int[] array = new int[30];
        for(int i = 0 ; i < array.length; i++){
            array[i] = (int)(Math.random() * 5);
        }

        for(int i : array)
            System.out.print(i + " ");
        System.out.println();

        System.out.println(Arrays.binarySearch(array, 3));

        System.out.println(binarySearch(array, 3));
    }

    private static int binarySearch(int[] array, int target){
        if(array.length == 1 && array[0] == target)
            return 0;

        if(array.length == 1 && array[0] != target)
            return -1;

        if(array.length == 0)
            return -1;


        int mid = array.length / 2;

        if(array[mid] == target)
            return mid;

        if(target < array[mid])
            return binarySearch(Arrays.copyOfRange(array, 0, mid), target);
        else
            return binarySearch(Arrays.copyOfRange(array, mid, array.length), target);
    }
}


/*
이진탐색은 정렬되어 있어야 함
 */