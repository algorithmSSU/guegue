package Search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ2110 {
    static int n, c;
    static int[] array;

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(br.readLine());
        }
    }

    public static void main(String[] args) throws IOException {
        input();

        process();
    }

    private static void process() {
        // ascending sort
        Arrays.sort(array);

        // binary search
        int right = 1000000000;
        int left = 0;
        int answerDistance = -1;

        while (left <= right) {
            int distance = (left + right) / 2;

            if (isAvailable(distance)) {
                left = distance + 1;
                answerDistance = distance;
            } else {
                right = distance - 1;
            }
        }

        System.out.println(answerDistance);
    }

    private static boolean isAvailable(int distance) {
        int homeDistance;
        int count = 1;
        int last = array[0];
        for (int i = 1; i < n; i++) {
            homeDistance = array[i] - last;
            if(homeDistance >= distance){
                count++;
                last = array[i];
            }
        }
        return count >= c;
    }

}



/*
관점을 바꿔서 최대 가능한 distance부터 이분탐색으로 O(logn) 탐색
이분탐색으로 결정한 distance를 array 순회하면서 놓을 수 있는 지(== 가능한 지) O(n) 탐색
가능한 경우 해당 answerDistance에 저장
 */