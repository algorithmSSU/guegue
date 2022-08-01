import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon14501 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int[] t = new int[n + 1];
        int[] p = new int[n + 1];
        int[] d = new int[n + 2];

        for (int i = 1; i < n + 1; i++) {
            st = new StringTokenizer(br.readLine());
            t[i] = Integer.parseInt(st.nextToken());
            p[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = d.length - 2; i > 0; i--) {
            if (i + t[i] > n + 1)
                d[i] = d[i + 1];
            else {
                d[i] = Math.max(d[i+1], d[i + t[i]] + p[i]);
            }
        }

        System.out.println(d[1]);

    }
}



/*
7
3 10
5 20
1 10
1 20
2 15
4 40
2 200
 */