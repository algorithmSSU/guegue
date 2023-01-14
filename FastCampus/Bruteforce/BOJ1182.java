package Bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1182 {
    static int n, s, answer;
    static int[] array;

    public static void main(String[] args) throws IOException {
        input();

        // dfs : 예상 calculateCount -> 32
        dfs(0, 0);

        if(s == 0)
            answer -= 1;
        System.out.println(answer);
    }


    private static void dfs(int depth, int value) {
        if(depth == n){
            if(s== value)
                answer++;
            return;
        }

        dfs(depth+1, value + array[depth]);
        dfs(depth+1, value);
    }


    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        answer = 0;
    }
}
/*
크기가 양수인 부분수열 -> 부분수열의 개수가 1 이상이여야 함
 */


























/*
static int N, S, count;
    static int[] num;

    public static void main(String[] args) throws IOException {
        input();

        rec_func(0, 0);

        // print
        if(S == 0)
            count--;
        System.out.println(count);
    }

    private static void rec_func(int depth, int sum){
        if(depth == N){
            if(S == sum)
                count++;
            return;
        }

        // 현재 depth 부분수열 처리
        rec_func(depth+1, sum + num[depth]);
        // 현재 depth 부분수열 미처리
        rec_func(depth+1, sum);
    }






    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        num = new int[N];
        S = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            num[i] = Integer.parseInt(st.nextToken());
        }
    }
 */