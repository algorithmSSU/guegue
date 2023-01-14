package Recursive;

public class Factorial {
    public static void main(String[] args) {
        System.out.println(recursiveFactorial(5));
    }

    private static int recursiveFactorial(int n){
        if(n == 1)
            return 1;

        return n * recursiveFactorial(n-1);
    }
}
