import java.util.*;
import java.io.*;

public class BaekJoon_13023_DFS {
    static ArrayList<Integer>[] friends;
    static boolean[] visited;
    static boolean arrive;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // set the number of people and friends relation
        int peopleNum = Integer.parseInt(st.nextToken());
        int relationNum = Integer.parseInt(st.nextToken());
        arrive = false;

        // set Arraylist, visted boolean array
        friends = new ArrayList[peopleNum];
        visited = new boolean[peopleNum];
        for (int i = 0; i < friends.length; i++) {
            friends[i] = new ArrayList<>();
        }

        //set friends relation
        for (int i = 0; i < relationNum; i++) {
            st = new StringTokenizer(br.readLine());
            int fr1 = Integer.parseInt(st.nextToken());
            int fr2 = Integer.parseInt(st.nextToken());

            //set arraylist (bidirection)
            friends[fr1].add(fr2);
            friends[fr2].add(fr1);
        }


        for (int i = 0; i < peopleNum; i++) {
            dfs(i, 0);
            if (arrive)
                break;
        }

        System.out.println(arrive ? 1 : 0);

    }

    private static void dfs(int idx, int depth) {
        if (depth == 4 || arrive) {
            arrive = true;
            return;
        }


        // change to visted
        visited[idx] = true;

        for (int adjacent : friends[idx]) {
            if (!visited[adjacent]) {
                dfs(adjacent, depth+1);
            }
        }
        visited[idx] = false;
    }
}

/*
[tmp]

[friends]
[1, 2, 3, 4, 5]
[0]
[0]
[0]
[0]
[0]
 */






/*
[Key Point]
{문제 풀기 전}
친구 관계 인접리스트화 (bidirection)
존재 or not == 모든 노드(친구)가 연결 or not
 */






/*
[Problem]
BOJ 알고리즘 캠프에는 총 N명이 참가하고 있다. 사람들은 0번부터 N-1번으로 번호가 매겨져 있고, 일부 사람들은 친구이다.

오늘은 다음과 같은 친구 관계를 가진 사람 A, B, C, D, E가 존재하는지 구해보려고 한다.

A는 B와 친구다.
B는 C와 친구다.
C는 D와 친구다.
D는 E와 친구다.
위와 같은 친구 관계가 존재하는지 안하는지 구하는 프로그램을 작성하시오.

[Input]
첫째 줄에 사람의 수 N (5 ≤ N ≤ 2000)과 친구 관계의 수 M (1 ≤ M ≤ 2000)이 주어진다.

둘째 줄부터 M개의 줄에는 정수 a와 b가 주어지며, a와 b가 친구라는 뜻이다. (0 ≤ a, b ≤ N-1, a ≠ b) 같은 친구 관계가 두 번 이상 주어지는 경우는 없다.

[Output]
문제의 조건에 맞는 A, B, C, D, E가 존재하면 1을 없으면 0을 출력한다.
 */