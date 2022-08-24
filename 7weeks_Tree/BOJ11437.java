import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.*;

public class BOJ11437 {
    private static ArrayList<Integer>[] trees;
    private static int[] level, parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        trees = new ArrayList[n + 1];
        for (int i = 1; i < trees.length; i++) {
            trees[i] = new ArrayList<>();
        }
        level = new int[trees.length];
        parent = new int[trees.length];

        //set trees
        for (int i = 1; i < trees.length - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int tmp1 = Integer.parseInt(st.nextToken());
            int tmp2 = Integer.parseInt(st.nextToken());

            trees[tmp1].add(tmp2);
            trees[tmp2].add(tmp1);
        }

        dfs(1, 1);

        // set targetNode
        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());
            System.out.println(lca(num1, level[num1], num2, level[num2]));
        }
    }

    private static void dfs(int n, int cnt) {
        level[n] = cnt++;

        for (int i : trees[n]) {
            if (level[i] == 0) {
                dfs(i, cnt);
                parent[i] = n;
            }
        }
    }

    private static int lca(int num1, int num1Depth, int num2, int num2Depth) {
        // level 맞추기
        if (num1Depth < num2Depth) {
            while (num1Depth != num2Depth) {
                num2Depth--;
                num2 = parent[num2];
            }
        } else if (num1Depth > num2Depth) {
            while (num1Depth != num2Depth) {
                num1Depth--;
                num1 = parent[num1];
            }
        }

        // lca 찾기
        while(num1 != num2){
            num1 = parent[num1];
            num2 = parent[num2];
        }
        return num1;
    }
}
/*
15
1 2
1 3
2 4
3 7
6 2
3 8
4 9
2 5
5 11
7 13
10 4
11 15
12 5
14 7
6
6 11
10 9
2 6
7 6
8 13
8 15
 */