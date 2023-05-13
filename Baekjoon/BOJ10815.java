import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ10815 {
    private static int[] array, target;


    public static void main(String[] args) throws IOException {
        init();

        Arrays.sort(array);

        process();
    }

    private static void process() {
        for (int thisTarget : target) {
            if (findNum(thisTarget)) {
                System.out.print(1 + " ");
            } else {
                System.out.print(0 + " ");
            }
        }
    }

    private static boolean findNum(int target) {
        int left = 0;
        int right = array.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (target == array[mid])
                return true;
            else if (target > array[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return false;
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // set array
        int n = Integer.parseInt(br.readLine());
        array = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        // set target
        int m = Integer.parseInt(br.readLine());
        target = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            target[i] = Integer.parseInt(st.nextToken());
        }
    }

}
