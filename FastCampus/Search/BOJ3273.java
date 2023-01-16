package Search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ3273 {
    static int n, x;
    static int[] array;


    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        array = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        x = Integer.parseInt(br.readLine());
    }

    public static void main(String[] args) throws IOException {
        input();

        process();
    }

    private static void process() {
        // sorting
        Arrays.sort(array);

        int count = 0;
        for (int i = 0; i < n - 1; i++) {
            int target = x - array[i];

            // 예외처리
            if (target <= 0)
                break;

            // binarySearch
            if (binarySearch(target, i + 1, n - 1))
                count++;
        }

        System.out.println(count);
    }

    private static boolean binarySearch(int target, int L, int R) {
        while (L <= R) {
            int mid = (L + R) / 2;

            if (array[mid] == target)
                return true;

            if (target < array[mid])
                R = mid - 1;
            else
                L = mid + 1;
        }

        return false;
    }
}
