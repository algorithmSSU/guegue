package Bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ15652 {
    static int n, m;
    static int[] array;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        input();

        dfs(0);

        System.out.println(sb.toString());
    }

    private static void dfs(int depth) {
        if (depth == m) {
            // print
            for (int i = 0; i < array.length; i++) {
                sb.append(array[i]).append(" ");
            }
            sb.append("\n");

            // return
            return;
        }

        int i;
        i = (depth > 0) ? array[depth - 1] - 1 : 0;

        for (; i < n; i++) {
            array[depth] = i + 1;
            dfs(depth + 1);
            array[depth] = 0;
        }
    }


    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        array = new int[m];
    }
}
