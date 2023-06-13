import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ1068_3 {
    private static int n, deleteNode, root;
    private static List<Integer>[] tree;
    private static int[] leafCount;

    public static void main(String[] args) throws IOException {
        init();

        deleteNode();

        calculateLeafNum(root);

        System.out.println(leafCount[root]);
    }

    private static void calculateLeafNum(int num) {
        if (deleteNode == root)
            return;

        if (tree[num].isEmpty()) {
            leafCount[num] = 1;
            return;
        }

        for (int children : tree[num]) {
            calculateLeafNum(children);
            leafCount[num] += leafCount[children];
        }
    }

    private static void deleteNode() {
        for (int i = 0; i < n; i++) {
            if (tree[i].contains(deleteNode)) {
                tree[i].remove(tree[i].indexOf(deleteNode));
            }
        }
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        // init root
        root = -1;

        // set tree
        tree = new List[n];
        for (int i = 0; i < n; i++) {
            tree[i] = new ArrayList<>();
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int parentNode = Integer.parseInt(st.nextToken());
            if (parentNode == -1) {
                root = i;
                continue;
            }

            tree[parentNode].add(i);
        }

        // set deleteNode
        deleteNode = Integer.parseInt(br.readLine());

        // init leafCount
        leafCount = new int[n];
    }

}
