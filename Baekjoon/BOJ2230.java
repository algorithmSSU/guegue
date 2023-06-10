import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ2230 {
    private static int n, m;
    private static int[] array;

    public static void main(String[] args) throws IOException {
        init();

        Arrays.sort(array);

        // process
        int right = 0;
        int minDifference = Integer.MAX_VALUE;
        for (int left = 1; left <= n; left++) {
            while (right + 1 <= n && (array[right] - array[left]) < m) {
                right++;
            }

            if((array[right] - array[left]) >= m){
                minDifference = Math.min(minDifference, (array[right] - array[left]));
            }
        }

        System.out.println(minDifference);
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // set n, m
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        // set array
        array = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            array[i] = Integer.parseInt(br.readLine());
        }

    }

}
