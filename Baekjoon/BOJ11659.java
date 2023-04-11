import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/11659
public class BOJ11659 {
    public static void main(String[] args) throws IOException {
        int[] array, sumArray;
        StringTokenizer st;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // set n, m
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        // set array
        array = new int[n];
        sumArray = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        // set sumArray
        sumArray[0] = array[0];
        for (int i = 1; i < n; i++) {
            sumArray[i] = sumArray[i - 1] + array[i];
        }

        for (int k = 0; k < m; k++) {
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken()) - 1;
            int j = Integer.parseInt(st.nextToken()) - 1;

            if (i == 0) {
                System.out.println(sumArray[j]);
            } else {
                System.out.println(sumArray[j] - sumArray[i - 1]);
            }

        }
    }
}

/*
진짜 쉬운 문제라고 생각했는데 실수한 게 있었음.

1. 입력 사이즈를 보면 1000보다 작거나 같은 자연수가 10만개까지 올 수 있는데 생각없이 int[]로 했음. long[]일 경우를 고려하지않고
int[]로 짠 것은 틀린 것이나 마찬가지

2. i, j의 범위가 1부터 시작이었음. 이런 경우 if 분기처리 해주지말고 new int[n+1] 해주면 가독성 측면에서 좋음. 문제 끝까지 읽고
자료구조 정하기

3. 구간합 배열!
 */