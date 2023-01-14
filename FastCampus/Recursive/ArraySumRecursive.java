package Recursive;

public class ArraySumRecursive {
    public static void main(String[] args) {
        int[] array = {2,5,6,2,3};

        System.out.println(arraySumRecursive(array));
    }

    private static int arraySumRecursive(int[] array){
        if(array.length == 0)
            return 0;

        //
        int[] newArray = new int[array.length-1];
        for(int i = 1; i < array.length; i++){
            newArray[i-1] = array[i];
        }

        return array[0] + arraySumRecursive(newArray);
    }
}
