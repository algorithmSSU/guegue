package Search;

public class SequentialSearch {
    public static void main(String[] args) {
        int[] array = new int[30];
        for(int i = 0 ; i < array.length; i++){
            array[i] = (int)(Math.random() * 30);
        }

        int idx = search(array, 20);
        System.out.println(idx);
        System.out.println(array[idx]);


    }

    private static int search(int[] array, int target){
        for(int i = 0 ; i < array.length; i++){
            if(array[i] == target)
                return i;
        }

        return -1;
    }
}
