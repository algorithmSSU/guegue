import java.util.*;
import java.io.*;

public class BOJ2805_2 {
    private static int[] tree;
    private static int n, m, treeMax;

    public static void main(String[] args) throws IOException {
        init();

        int answer = getMaxHeight();
        System.out.println(answer);
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // set n, m;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        // set tree, treeMax
        tree = new int[n];
        treeMax = Integer.MIN_VALUE;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            tree[i] = Integer.parseInt(st.nextToken());
            treeMax = Math.max(treeMax, tree[i]);
        }
    }

    private static int getMaxHeight() {
        int answer = -1;
        int left = 0, right = treeMax;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (validate(mid)) {
                left = mid + 1;
                answer = mid;
            } else {
                right = mid - 1;
            }
        }

        return answer;
    }

    private static boolean validate(int mid) {
        long sumTree = 0;
        for (int thisTree : tree) {
            if (mid < thisTree && sumTree <= m) {
                sumTree += thisTree - mid;
            }
        }

        return m <= sumTree;
    }
}
