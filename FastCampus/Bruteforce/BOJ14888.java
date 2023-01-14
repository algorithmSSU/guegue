package Bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ14888 {
    static int n, max, min;
    static int[] num, operators;

    public static void main(String[] args) throws IOException {
        input();

        dfs(1, num[0]);

        System.out.println(max);
        System.out.println(min);
    }

    private static void dfs(int depth, int sum) {
        if (depth == n) {
            min = Math.min(min, sum);
            max = Math.max(max, sum);
            return;
        }

        for (int i = 0; i < 4; i++) {
            // 연산자 개수가 존재하는 경우
            if(operators[i] > 0){
                operators[i]--;
                dfs(depth+1, calc(sum, i, num[depth]));
                operators[i]++;
            }
        }

    }

    private static int calc(int operand1, int operator, int operand2){
        switch (operator){
            case 0:
                return operand1 + operand2;
            case 1:
                return operand1 - operand2;
            case 2:
                return operand1 * operand2;
            case 3:
                return operand1 / operand2;
            default:
                System.out.println("Error : operator num is wrong!");
                return -1;
        }
    }


    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        num = new int[n];

        // initialize num
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        // initialize operators
        operators = new int[4];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            operators[i] = Integer.parseInt(st.nextToken());
        }

        // initialize min, max
        min = Integer.MAX_VALUE;
        max = Integer.MIN_VALUE;
    }

}




/*
static int N, min, max;
    static int[] num, operators, orders;
    static StringBuilder sb = new StringBuilder();

    static private void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        num = new int[N+1];

        orders = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 1 ; i <= N; i++){
            num[i] = Integer.parseInt(st.nextToken());
        }

        operators = new int[4+1];
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= 4; i++){
            operators[i] = Integer.parseInt(st.nextToken());
        }

        min = Integer.MAX_VALUE;
        max = Integer.MIN_VALUE;
    }

    public static void main(String[] args) throws IOException {
        input();

        dfs(1, num[1]);

        sb.append(max).append("\n").append(min);
        System.out.println(sb.toString());
    }

    private static void dfs(int depth, int sum){
        if(depth == N){
            max = Math.max(max, sum);
            min = Math.min(min, sum);

            return;
        }

        for(int i = 1; i <= 4; i++){
            if(operators[i] > 0){
                operators[i]--;

                int tmpSum = sum;
                if(i == 1){
                    tmpSum += num[depth+1];
                }
                if(i == 2){
                    tmpSum -= num[depth+1];
                }
                if(i == 3){
                    tmpSum *= num[depth+1];
                }
                if(i == 4){
                    tmpSum /= num[depth+1];
                }
                dfs(depth+1, tmpSum);
                operators[i]++;
            }
        }
    }
 */