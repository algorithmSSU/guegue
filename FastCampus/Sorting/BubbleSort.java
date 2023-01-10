package Sorting;

public class BubbleSort {
    public static void main(String[] args) {
        int[] array = new int[200];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 200);
        }

        for (int i = 0; i < array.length - 1; i++) {
            boolean change = false;
            for (int j = 0; j < array.length - (i + 1); j++) {
                if(array[j] > array[j+1]){
                    swapInArray(array, j, j+1);
                    change = true;
                }
            }

            if(!change)
                break;
        }
        System.out.println(printArray(array));
    }

    public static String printArray(int[] array) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            sb.append(array[i]).append(" ");
            if ((i + 1) % 40 == 0)
                sb.append("\n");
        }

        return sb.toString();
    }

    public static void swapInArray(int[] array, int x, int y){
        int tmp = array[y];
        array[y] = array[x];
        array[x] = tmp;
    }
}


/*
Bubble sort
- 두 개씩 비교하여 순서를 반복적으로 바꾸기. 이를 n-1번 반복
- O(n^2)
 */