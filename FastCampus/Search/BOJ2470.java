package Search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ2470 {
    static int n;
    static int[] array;

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        array = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < array.length; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }
    }

    public static void main(String[] args) throws IOException {
        input();

        process();
    }

    private static void process() {
        // binary search를 위한 ascending sort
        Arrays.sort(array);

        int nearestZero = Integer.MAX_VALUE;
        int water1 = Integer.MAX_VALUE;
        int water2 = Integer.MAX_VALUE;

        for (int idx = 0; idx < n - 1; idx++) {
            // 현재 idx 뒤에 있는 배열을 상대로 binary search
            int targetIdx = binarySearch(-array[idx], idx + 1, n - 1);

            if (targetIdx > idx && targetIdx < n && Math.abs(array[targetIdx] + array[idx]) < nearestZero) {
                nearestZero = Math.abs(array[targetIdx] + array[idx]);
                water1 = array[idx];
                water2 = array[targetIdx];
            }

            targetIdx--;
            if (targetIdx > idx && targetIdx < n && Math.abs(array[targetIdx] + array[idx]) < nearestZero) {
                nearestZero = Math.abs(array[targetIdx] + array[idx]);
                water1 = array[idx];
                water2 = array[targetIdx];
            }
        }

        System.out.println(water1 + " " + water2);
    }

    /*
    target 이상인 수 중에 제일 작은 idx 리턴
     */
    private static int binarySearch(int target, int left, int right) {
        int answerIdx = right + 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (target <= array[mid]) {
                answerIdx = mid;
                right = mid -1;
            }else{
                left = mid + 1;
            }
        }

        return answerIdx;
    }
}
