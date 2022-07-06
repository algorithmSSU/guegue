import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Test {
    static ArrayList<Integer>[] lists;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        lists = new ArrayList[N+1]; //idx start -> 1
        visited = new boolean[N+1];
        for(int i = 1; i <lists.length; i++){
            lists[i] = new ArrayList<>();
        }
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            lists[a].add(b);
        }
        // ------------------------------------------------------------------------

        Queue<Integer> queue = new LinkedList<>();
        ArrayList<Integer> sequence = new ArrayList<>();

        queue.add(1);
        while(!queue.isEmpty()){
            int tmp = queue.poll();
            if(visited[tmp])
                continue;


            visited[tmp] = true;
            for(int i : lists[tmp]){
                if(!visited[i])
                    queue.add(i);
            }

            sequence.add(tmp);
        }

        System.out.println(sequence);

    }
}

/*
6 6
1 2
1 3
2 5
2 6
3 4
4 6
 */