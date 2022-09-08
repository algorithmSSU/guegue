import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ14267 {
    private static ArrayList<Integer>[] arrayLists;
    private static int[] complimentCount;
    private static boolean[] isVisited;

    public static void main(String[] args) throws IOException {
        StringTokenizer st;
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));

        // set input
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        // set arrayLists
        complimentCount = new int[n+1];
        arrayLists = new ArrayList[n+1];
        for(int i = 1; i < arrayLists.length; i++){
            arrayLists[i] = new ArrayList<>();
        }
        st = new StringTokenizer(br.readLine());
        st.nextToken();
        for(int i = 2; i < arrayLists.length; i++){
            int boss = Integer.parseInt(st.nextToken()); // 상사
            arrayLists[boss].add(i);
        }

        // save complimentCount
        for(int i = 0 ; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int subordinate = Integer.parseInt(st.nextToken());
            int compliment = Integer.parseInt(st.nextToken());

            complimentCount[subordinate] += compliment;
        }

        // dfs
        isVisited = new boolean[arrayLists.length];
        isVisited[1] = true;
        dfs(1);

        // print
        for(int i = 1; i < complimentCount.length; i++){
            System.out.print(complimentCount[i] + " ");
        }

    }
    private static void dfs(int num){
        for(int i : arrayLists[num]){
            if(!isVisited[i]){
                complimentCount[i] += complimentCount[num];
                dfs(i);
            }
        }
    }
}
/*
5 3
-1 1 2 3 4
2 2
3 4
5 6
*/
