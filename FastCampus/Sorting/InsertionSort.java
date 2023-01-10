package Sorting;

public class InsertionSort {
    public static void main(String[] args) {
        int[] array = new int[200];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 200);
        }

        for(int i = 1; i < array.length; i++){
            int j;
            for(j = i; j > 0; j--){
                if(array[j] < array[j-1])
                    BubbleSort.swapInArray(array, j, j-1);
                else
                    break;
            }
        }

        System.out.println(BubbleSort.printArray(array));
    }
}
