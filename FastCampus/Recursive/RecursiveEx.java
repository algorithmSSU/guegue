package Recursive;

public class RecursiveEx {
    public static void main(String[] args) {
        System.out.println(express123Recursive(10));
    }

    private static int express123Recursive(int num){
        if(num == 1)
            return 1;
        else if(num == 2)
            return 2;
        else if(num == 3)
            return 4;

        return express123Recursive(num-1) + express123Recursive(num-2) + express123Recursive(num-3);
    }
}
