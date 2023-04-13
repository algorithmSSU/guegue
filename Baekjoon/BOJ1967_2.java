import java.util.*;
import java.io.*;

public class BOJ1967_2 {
    static class Node {
        int idx;
        int weight;

        Node(int idx, int weight) {
            this.idx = idx;
            this.weight = weight;
        }
    }

    private static List<Node>[] tree;
    private static boolean[] isVisited;
    private static int n, treeMaxDiameter;

    public static void main(String[] args) throws IOException {
        init();

        for (int i = 1; i <= n; i++) {
            findTreeMaxDiameter(i, 0);
        }

        System.out.println(treeMaxDiameter);
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        tree = new List[n + 1];
        for (int i = 1; i <= n; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            tree[parent].add(new Node(child, weight));
            tree[child].add(new Node(parent, weight));
        }

        isVisited = new boolean[n + 1];

        treeMaxDiameter = Integer.MIN_VALUE;
    }

    private static void findTreeMaxDiameter(int idx, int sumWeight) {
        isVisited[idx] = true;
        treeMaxDiameter = Math.max(treeMaxDiameter, sumWeight);

        for (Node node : tree[idx]) {
            if (!isVisited[node.idx])
                findTreeMaxDiameter(node.idx, sumWeight + node.weight);
        }

        isVisited[idx] = false;
    }
}
