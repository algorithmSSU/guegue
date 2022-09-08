import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ4803 {
    private static ArrayList<Integer>[] arrayLists;
    private static boolean[] isVisted;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = 0;
        while(true){
            T++;
            // set vertexCount, edgeCount
            st = new StringTokenizer(br.readLine());
            int vertexCount = Integer.parseInt(st.nextToken());
            int edgeCount = Integer.parseInt(st.nextToken());

            // 종료조건 체크
            if(vertexCount == 0 && edgeCount == 0)
                break;

            // initilaize tree
            arrayLists = new ArrayList[vertexCount+1];
            for(int i = 1 ; i < arrayLists.length; i++){
                arrayLists[i] = new ArrayList<>();
            }
            isVisted = new boolean[vertexCount + 1];
            for(int i = 0; i < edgeCount; i++){
                st = new StringTokenizer(br.readLine());
                int vertex1 = Integer.parseInt(st.nextToken());
                int vertex2 = Integer.parseInt(st.nextToken());
                arrayLists[vertex1].add(vertex2);
                arrayLists[vertex2].add(vertex1);
            }

            // dfs
            int answer = 0;
            for(int i = 1; i < arrayLists.length; i++){
                if(!isVisted[i]){
                    isVisted[i] = true;
                    if(dfs(-1, i))
                        answer++;
                }
            }

            // append answer
            sb.append("Case ").append(T).append(": ");
            if(answer == 0)
                sb.append("No trees.");
            else if (answer == 1)
                sb.append("There is one tree.");
            else
                sb.append("A forest of ").append(answer).append(" trees.");
            sb.append("\n");
        }

        // print answer
        System.out.println(sb);
    }

    private static boolean dfs(int root, int num){
        for(int i : arrayLists[num]){
            // vertex가 독립적으로 한 개 있을 경우
            if(i == root)
                continue;

            // vertex가 방문한 적 있는 vertex 방문하는 경우 (싸이클인 경우)
            if(isVisted[i])
                return false;

            // recursive call
            isVisted[i] = true;
            if(!dfs(num, i))
                return false;
        }
        // 모든 예외사항 통과 했으면 Tree 처리
        return true;
    }
}
