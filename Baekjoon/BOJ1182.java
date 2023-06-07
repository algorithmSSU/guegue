import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ1182 {
    private static int n, s, count = 0;
    private static int[] array;

    public static void main(String[] args) throws IOException {
        init();

        combinationOtherVersion(0, 0);

        if(s == 0)
            count--;
        System.out.println(count);
    }

    private static void combination(int value, int depth) {
        if(value == s)
            count++;
        if(depth == n){
            return;
        }

        for (int i = depth; i < n; i++) {
            combination(value + array[i], i + 1);
        }
    }

    private static void combinationOtherVersion(int depth, int value){
        if(depth == n){
            if(value == s){
                count++;
            }
            return;
        }

        combinationOtherVersion(depth + 1, value);
        combinationOtherVersion(depth + 1, value + array[depth]);
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());

        // init array
        array = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }
    }

}
