import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ10870 {
    static int n;
    static int[] fibonacci;

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        fibonacci = new int[21];
    }

    public static void main(String[] args) throws IOException {
        input();

        process();
    }

    private static void process(){
        setFibonacci();

        // print answer
        System.out.println(fibonacci[n]);
    }

    private static void setFibonacci(){
        // set init
        fibonacci[1] = 1;

        // set others
        for(int i = 2; i <= 20; i++){
            fibonacci[i] = fibonacci[i-1] + fibonacci[i-2];
        }
    }
}

