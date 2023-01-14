package Bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ15649 {
    static int n, m;
    static int[] array;
    static StringBuilder sb = new StringBuilder();
    static boolean[] visited;

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

        for(int i = 0 ; i < n; i++){
            if(!visited[i]){
                visited[i] = true;
                array[depth] = i+1;
                dfs(depth+1);
                visited[i] = false;
                array[depth] = 0;
            }
        }
    }


    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        visited = new boolean[n];

        array = new int[m];
    }
}



/*
문제 : https://www.acmicpc.net/problem/15649
 */