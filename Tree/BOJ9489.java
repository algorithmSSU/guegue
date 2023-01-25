import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;
        import java.util.ArrayList;
        import java.util.List;
        import java.util.StringTokenizer;

public class BOJ9489 {
    /**
     * 1. set tree
     * 2. get depth of k
     * 3. find nodes that have same depth of k
     */
    static int n, k, kIdx, answer;
    static int[] array, parent;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private static boolean input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        // 종료 조건
        if (n == 0 && k == 0) return false;

        // set array, kIdx
        st = new StringTokenizer(br.readLine());
        array = new int[n];
        kIdx = -1;
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(st.nextToken());
            // k의 idx 저장
            if (array[i] == k)
                kIdx = i;
        }

        // set tree
        parent = new int[n];
        parent[0] = -1;

        // set parent
        int lastNode = -1;
        if (n >= 2) lastNode = array[1] - 1;
        int nowParentIdx = 0;
        for (int i = 1; i < n; i++) {
            int thisNode = array[i];

            // 부모 달라지는 경우
            if (lastNode + 1 != thisNode) {
                nowParentIdx++;
            }


            parent[i] = nowParentIdx;
            lastNode = thisNode;
        }

        answer = 0;

        return true;
    }

    public static void main(String[] args) throws IOException {
        while (true) {
            if (input()) process();
            else break;
        }
    }

    private static void process() {
        // find cousin
        for (int i = 0; i < n; i++) {
            // 루트인 경우
            if(parent[i] == -1) continue;
            if(parent[i] == parent[kIdx]) continue;

            if(parent[parent[i]] == parent[parent[kIdx]]){
                answer++;
            }
        }

        // print answer
        System.out.println(answer);
    }
}