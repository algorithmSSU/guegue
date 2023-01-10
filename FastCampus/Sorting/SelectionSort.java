package Sorting;

public class SelectionSort {
    public static void main(String[] args) {
        int[] array = new int[200];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 200);
        }

        // selection sort
        for(int i = 0 ; i < array.length-1; i++){
            int target = array[i];
            int targetIdx = i;
            for(int j = i+1; j < array.length; j++){
                if(target > array[j]){
                    target = array[j];
                     targetIdx = j;
                }
            }

            BubbleSort.swapInArray(array, i, targetIdx);
        }

        // print
        System.out.println(BubbleSort.printArray(array));;
    }
}



/*
Selection Sort

전체 데이터 순회하면서 가장 작은 값 선택 후 앞의 idx랑 교환
 */