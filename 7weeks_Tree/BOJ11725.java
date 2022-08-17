import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ11725 {
    static ArrayList<Integer>[] arrayLists;
    static boolean[] isVisit;
    static Map<Integer, Integer> answer = new HashMap<>();

    public static void main(String[] args) throws IOException {
        //set input values
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        isVisit = new boolean[N+1];

        //set trees
        arrayLists = new ArrayList[N + 1];
        for (int i = 1; i < arrayLists.length; i++) {
            arrayLists[i] = new ArrayList<>();
        }
        StringTokenizer st;
        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int tmp1 = Integer.parseInt(st.nextToken());
            int tmp2 = Integer.parseInt(st.nextToken());
            arrayLists[tmp1].add(tmp2);
            arrayLists[tmp2].add(tmp1);
        }

        //dfs(save parents node)
        dfs(1);

        for(int i = 2; i <= N; i++){
            System.out.println(answer.get(i));
        }
    }

    private static void dfs(int num){
        isVisit[num] = true;

        for(int i : arrayLists[num]){
            if(!isVisit[i]){
                answer.put(i, num);
                dfs(i);
            }
        }
    }
}
