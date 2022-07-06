import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

public class BaekJoon_2178_BFS {
    static int[][] num;
    static boolean[][] visited;
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        num = new int[N][M];
        visited = new boolean[N][M];

        for(int i =0; i < N; i++){
            String tmp = br.readLine();
            for(int j = 0; j < M; j++){
                num[i][j] = Integer.parseInt(Character.toString(tmp.charAt(j)));
            }
        }

        BFS(0, 0);

        System.out.println(num[N-1][M-1]);

    }

    private static void BFS(int x, int y){
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {x, y});

        while(!queue.isEmpty()){
            int[] tmp = queue.poll();
            visited[x][y] = true;

            for(int i = 0; i < 4; i++){
                int tmp_x = tmp[0] + dx[i];
                int tmp_y = tmp[1] + dy[i];

                if(tmp_x >= 0 && tmp_y >=0 && tmp_x < N && tmp_y < M){
                    if(!visited[tmp_x][tmp_y] && num[tmp_x][tmp_y] != 0){
                        visited[tmp_x][tmp_y] = true;
                        num[tmp_x][tmp_y] = num[tmp[0]][tmp[1]] + 1;
                        queue.add(new int[] {tmp_x, tmp_y});
                    }
                }
            }
        }
    }
}


/*
dx -> 010-1
dy -> 10-10

for k 4
x + dx[k]
y + dy[k]
 */


/*
[메모리 관련]
내 방법
1. 처음 Queue에 초기값 넣어주기
2. While문 돌면서 Queue의 item 꺼내서 해당 item 방문 처리해주기
3. Queue에 새로운 item 넣어주기 위한 if문 검사 후 Queue에 넣어주기


메모리 낭비 줄이는 법
1. 처음 Queue에 초기값 넣어주기
2. 초기값에 대한 방문 처리 해주기
3. Queue에 새로운 item 넣어주기 위한 if문 검사 후 방문 처리를 해준 후에 Queue에 넣어주기


차이
-> 초기값 Queue에 삽입 하면서 방문처리
-> Queue에 새로운 item 넣어주기 위한 if문 검사 후에 Queue에 넣기 전에 방문 처리를 해주기!!!

 */