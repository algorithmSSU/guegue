package Search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ7795 {
    private static int T, n, m;
    private static int[] nArray, mArray;
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        nArray = new int[n];
        mArray = new int[m];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            nArray[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            mArray[i] = Integer.parseInt(st.nextToken());
        }
    }

    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            input();

            process();
        }
    }

    private static void process() {
        // binary search를 위한 ascending sorting
        Arrays.sort(mArray);

        int count = 0;
        for (int i = 0; i < nArray.length; i++) {
            int target = nArray[i];

            // binary search 를 통한 먹이 개수 구하기
            count += getFoodCount(target);
        }

        System.out.println(count);
    }

    private static int getFoodCount(int target) {
        int answerCount = 0;

        int left = 0;
        int right = m - 1;
        int mid;

        while (left <= right) {
            mid = (left + right) / 2;

            if (target > mArray[mid]) {
                answerCount = mid + 1;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return answerCount;
    }

}






















/*
static int T, n, m;
    static int[] nArray, mArray;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            input();

            // ascending sort
            Arrays.sort(mArray);

            System.out.println(process());
        }
    }

    private static int process() {
        int count = 0;

        for (int i = 0; i < nArray.length; i++) {
            count += binarySearch(nArray[i]);
        }

        return count;
    }

    private static int binarySearch(int target) {
        int left = 0;
        int right = mArray.length - 1;
        int mid;
        int answer = 0;

        while (left <= right) {
            mid = (left + right) / 2;

            if (target > mArray[mid]) {
                left = mid + 1;
                answer = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return answer;
    }


    private static void input() throws IOException {
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        nArray = new int[n];
        mArray = new int[m];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            nArray[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            mArray[i] = Integer.parseInt(st.nextToken());
        }
    }
 */