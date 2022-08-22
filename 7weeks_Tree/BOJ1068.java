import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ1068 {
    private static ArrayList<Integer>[] trees;
    private static boolean[] visited;
    private static int count;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        trees = new ArrayList[n];
        for (int i = 0; i < trees.length; i++)
            trees[i] = new ArrayList<>();
        visited = new boolean[n];


        // set trees
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < trees.length; i++) {
            int tmp = Integer.parseInt(st.nextToken());
            if (tmp == -1) {
                continue;
            }
            else {
                trees[tmp].add(i);
                trees[i].add(tmp);
            }
        }


        // 삭제할 노드를 ArrayList[]에서 삭제
        int deleteNodeIdx = Integer.parseInt(br.readLine());
        for(int i : trees[deleteNodeIdx]){
            trees[i].remove(Integer.valueOf(deleteNodeIdx));
        }
        trees[0].add(0);
        trees[deleteNodeIdx].clear();




        for(int i = 0 ; i < trees.length; i++){
            System.out.println(trees[i]);
        }
//        System.exit(1);

        // dfs
        dfs(0);

        // print count
        System.out.println(count);
    }

    private static void dfs(int num) {
        // 방문 처리
        visited[num] = true;

        if (trees[num].size() == 1) {
            System.out.println("num : " + num);
            System.out.println(trees[num]);
            count++;
        }
        else {
            for (int i : trees[num]) {
                if(!visited[i])
                    dfs(i);
            }
        }
    }
}

// 삭제를 함으로써 리프가 되는 경우 고려

/*
5
-1 0 0 1 1
2
 */