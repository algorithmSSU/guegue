import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ2805 {
    private static int n, m;
    private static int[] array;

    public static void main(String[] args) throws IOException {
        init();

        Arrays.sort(array);

        // process
        long left = 0; long right = array[array.length - 1];
        long maxHeight = 0;
        while (left <= right) {
            long mid = (left + right) / 2;

            if(isPossible(mid)){
                maxHeight = mid;
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }

        System.out.println(maxHeight);
    }

    private static boolean isPossible(long target){
        long answer = 0;

        for(int i = array.length - 1; i >= 0; i--){
            if(array[i] <= target){
                break;
            }
            answer += (array[i] - target);
        }

        return answer >= m;
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // set n, m;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        // array
        st = new StringTokenizer(br.readLine());
        array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }
    }
}
