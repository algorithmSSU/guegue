import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/11660
public class BOJ11660 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // init nm
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        // init array
        int[][] array = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                array[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // init sumArray
        int[][] sumArray = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                sumArray[i][j] = sumArray[i - 1][j] + sumArray[i][j - 1] - sumArray[i - 1][j - 1] + array[i][j];
            }
        }

        // print answer
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int y1 = Integer.parseInt(st.nextToken());
            int x1 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());

            System.out.println(sumArray[y2][x2] - (sumArray[y2][x1 - 1] + sumArray[y1 - 1][x2] - sumArray[y1 - 1][x1 - 1]));
        }
    }
}

/*
구간합 구하기5

dp 개념 이용해서 미리 배열합 구해놓고 더하기 뺴기만 잘해주면 쉬웠음.
 */