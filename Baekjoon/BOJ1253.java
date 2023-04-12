import java.util.*;
import java.io.*;

public class BOJ1253 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(array);

        int count = 0;
        for (int i = 0; i < n; i++) {
            int left = 0, right = array.length - 1;
            int nowElement = array[i];
            while (left < right) {
                if (left == i) {
                    left++;
                    continue;
                }
                if (right == i) {
                    right--;
                    continue;
                }

                int sum = array[left] + array[right];
                if (sum == nowElement) {
                    count++;
                    break;
                } else if (sum > nowElement) {
                    right--;
                } else {
                    left++;
                }
            }
        }

        System.out.println(count);
    }
}