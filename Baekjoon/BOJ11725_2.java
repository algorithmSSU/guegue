import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ11725_2 {
    private static final int ROOT = 1;
    private static List<Integer>[] tree;
    private static int[] parentInfoOfNode;

    public static void main(String[] args) throws IOException {
        init();

        setParentInfoOfNode();

        // print answer
        for (int i = 2; i < parentInfoOfNode.length; i++) {
            System.out.println(parentInfoOfNode[i]);
        }
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        // set tree
        tree = new List[n + 1];
        for (int i = 1; i <= n; i++) {
            tree[i] = new ArrayList<>();
        }
        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());

            tree[node1].add(node2);
            tree[node2].add(node1);
        }

        //
        parentInfoOfNode = new int[n+1];
    }

    private static void setParentInfoOfNode() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(ROOT);
        parentInfoOfNode[ROOT] = -1;

        while (!queue.isEmpty()) {
            int parentNode = queue.poll();

            for (int childNode : tree[parentNode]) {
                if (parentInfoOfNode[childNode] == 0) {
                    parentInfoOfNode[childNode] = parentNode;
                    queue.add(childNode);
                }
            }
        }
    }
}
