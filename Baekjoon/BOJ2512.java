import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ2512 {
    private static int n, allSum;
    private static int[] array;

    public static void main(String[] args) throws IOException {
        init();

        Arrays.sort(array);

        // process
        int left = 1;
        int right = allSum;
        int answer = 0;
        while (left <= right) {
            int sum = (left + right) / 2; // 배정할 예산

            if (isPossible(sum)) {
                left = sum + 1;
                answer = sum;
            } else {
                right = sum - 1;
            }
        }

        System.out.println(answer);
    }

    private static boolean isPossible(int targetSum) {
        if(targetSum > array[array.length - 1])
            return false;

        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            int now = array[i];

            if (targetSum < now) {
                now = targetSum;
            }
            sum += now;
        }
        return sum <= allSum;
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        // set array
        array = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        // set allSum
        allSum = Integer.parseInt(br.readLine());
    }
}