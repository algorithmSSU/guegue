import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ15565 {
    private static final int RYAN = 1, APEACH = 2;
    private static int n, k;
    private static int[] array;

    public static void main(String[] args) throws IOException {
        init();

        int ryanCount = 0;
        int right = 0;
        int minLength = Integer.MAX_VALUE;
        for(int left = 1; left <= n; left++){
            if(array[left - 1] == RYAN)
                ryanCount -= 1;

            while(right + 1 <= n && ryanCount < k){
                right++;
                if(array[right] == RYAN)
                    ryanCount += 1;
            }

            if(ryanCount >= k){
                minLength = Math.min(minLength, (right - left) + 1);
            }
        }

        System.out.println((minLength != Integer.MAX_VALUE) ? minLength : -1);
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        array = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }
    }

}
