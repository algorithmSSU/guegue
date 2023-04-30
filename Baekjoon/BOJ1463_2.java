import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1463_2 {
    private static int[] array;
    private static int n;

    public static void main(String[] args) throws IOException {
        init();

        dp();
        System.out.println(array[n]);
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        array = new int[n + 1];
    }

    private static void dp() {
        // init
        if (n >= 2) {
            array[2] = 1;
        }
        if (n >= 3) {
            array[3] = 1;
        }

        for (int i = 4; i <= n; i++) {
            int lastNum = array[i-1];
            if(i % 2 == 0){
                lastNum = Math.min(lastNum, array[i / 2]);
            }
            if(i % 3 == 0){
                lastNum = Math.min(lastNum, array[i / 3]);
            }
            array[i] = lastNum + 1;
        }
    }
}
