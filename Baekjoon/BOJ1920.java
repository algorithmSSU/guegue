import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ1920 {
    private static int n;
    private static int[] array, target;

    public static void main(String[] args) throws IOException {
        init();

        Arrays.sort(array);
        for (int thisTarget : target) {
            if(Arrays.binarySearch(array, thisTarget) >= 0)
                System.out.println(1);
            else
                System.out.println(0);
        }
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        array = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        int targetSize = Integer.parseInt(br.readLine());
        target = new int[targetSize];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < targetSize; i++) {
            target[i] = Integer.parseInt(st.nextToken());
        }
    }

}
