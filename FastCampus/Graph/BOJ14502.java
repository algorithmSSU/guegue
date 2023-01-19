package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ14502 {
    static int n, m, safeCount;
    static int[][] arrayMap;
    static int[][] direction = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // 상하좌우
    static boolean[][] visited;
    static List<Integer> safeZoneList;
    static List<Integer> virusList;

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arrayMap = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arrayMap[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        safeCount = 0;

        safeZoneList = new ArrayList<>();
        virusList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arrayMap[i][j] == 0) {
                    safeZoneList.add(i);
                    safeZoneList.add(j);
                } else if (arrayMap[i][j] == 2) {
                    virusList.add(i);
                    virusList.add(j);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        input();

        process();
    }

    private static void process() {
        // 모든 경우의 수에 벽 세워보기
        dfsSetWall(0, 0);

        // answer print
        System.out.println(safeCount);
    }

    private static void dfsSetWall(int safeZoneIdx, int wallCount) {
        if (wallCount == (3)) {
            spreadVirus();
            return;
        }
        if (safeZoneList.size() <= (safeZoneIdx + 1)) {
            return;
        }

        arrayMap[safeZoneList.get(safeZoneIdx)][safeZoneList.get(safeZoneIdx + 1)] = 1;
        dfsSetWall(safeZoneIdx + 2, wallCount + 1);

        arrayMap[safeZoneList.get(safeZoneIdx)][safeZoneList.get(safeZoneIdx + 1)] = 0;
        dfsSetWall(safeZoneIdx + 2, wallCount);
    }

    private static void spreadVirus() {
        Queue<Integer> queue = new LinkedList<>(virusList);
        visited = new boolean[n][m];

        // 큐에 들어간 바이러스 좌표 방문처리
        for (int i = 0; i < virusList.size(); i += 2) {
            visited[virusList.get(i)][virusList.get(i + 1)] = true;
        }

        while (!queue.isEmpty()) {
            int thisY = queue.poll();
            int thisX = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nextY = thisY + direction[i][0];
                int nextX = thisX + direction[i][1];

                if (nextY < 0 || nextX < 0 || nextY >= n || nextX >= m) continue;
                if (arrayMap[nextY][nextX] != 0) continue;
                if (visited[nextY][nextX]) continue;

                visited[nextY][nextX] = true;
                queue.add(nextY);
                queue.add(nextX);
            }
        }

        // update safeCount
        int nowSafeZoneCount = getSafeCount();
        safeCount = Math.max(safeCount, nowSafeZoneCount);
    }

    private static int getSafeCount() {
        int answerCount = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arrayMap[i][j] != 0) continue;
                if (visited[i][j]) continue;

                answerCount++;
            }
        }

        return answerCount;
    }

    private static void printArray(int[][] array) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void printArray(boolean[][] array) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }
}



/*
연구소
https://www.acmicpc.net/problem/14502

1. 벽 세우기
2. 바이러스 확산
3. safeZone 개수 세기
 */