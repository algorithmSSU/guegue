import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ1744 {
    private static int[] array;
    private static int sum, n;

    public static void main(String[] args) throws IOException {
        init();

        setSum();

        System.out.println(sum);
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(array);
    }

    private static void setSum() {
        // process 양의 정수
        int idx = n - 1;
        while (idx >= 0 && array[idx] > 0) {
            int num1 = array[idx--];
            int num2;

            if (idx >= 0 && array[idx] > 0) {
                num2 = array[idx--];
                if(num1 == 1 || num2 == 1){
                    sum += (num1 + num2);
                }else{
                    sum += num1 * num2;
                }
            }else{
                num2 = 1;
                sum += num1 * num2;
            }
        }

        // process 음의 정수와 0
        for(int i = 0; i <= idx; i += 2){
            int num1 = array[i];
            int num2 = (i+1 < n && array[i+1] <= 0) ? array[i+1] : 1;
            sum += (num1 * num2);
        }
    }
}
