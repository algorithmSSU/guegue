import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ3273 {
    private static int n, target;
    private static int[] array;

    public static void main(String[] args) throws IOException {
        init();

        // sort
        Arrays.sort(array);

        int left = 0;
        int right = array.length - 1;
        int answerCount = 0;
        while (left < right) {
            int sum = array[left] + array[right];

            if (sum == target) {
                answerCount++;
                left++;
            } else if (target < sum) {
                right--;
            } else if (sum < target) {
                left++;
            }
        }

        System.out.println(answerCount);
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        target = Integer.parseInt(br.readLine());
    }

}