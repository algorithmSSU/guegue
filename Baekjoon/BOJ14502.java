import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ14502 {
    private static final int EMPTY = 0, WALL = 1, VIRUS = 2;

    private static int n, m, maxSafeCount;
    private static int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private static List<Integer> wall, virus;
    private static int[][] room;
    private static boolean[][] isVisited;

    public static void main(String[] args) throws IOException {
        init();

        setWall(0);
        System.out.println(maxSafeCount);
    }

    private static void setWall(int wallCount) {
        if (wallCount == 3) {
            // virus spread
            spreadVirus();


            return;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (room[i][j] == WALL) continue;
                if (room[i][j] == VIRUS) continue;
                if (isVisited[i][j]) continue;

                isVisited[i][j] = true;
                room[i][j] = WALL;

                setWall(wallCount + 1);

                isVisited[i][j] = false;
                room[i][j] = EMPTY;
            }
        }
    }

    private static void spreadVirus() {
        int[][] copyRoom = new int[room.length][room[0].length];
        for (int i = 0; i < room.length; i++) {
            copyRoom[i] = room[i].clone();
        }

        boolean[][] copyVisited = new boolean[room.length][room[0].length];

        // init queue
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < virus.size(); i += 2) {
            queue.add(virus.get(i));
            queue.add(virus.get(i + 1));
            copyVisited[virus.get(i)][virus.get(i + 1)] = true;
        }

        while (!queue.isEmpty()) {
            int nowY = queue.poll();
            int nowX = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nextY = nowY + directions[i][0];
                int nextX = nowX + directions[i][1];

                if (nextY < 0 || nextX < 0 || nextY >= n || nextX >= m) continue;
                if (copyRoom[nextY][nextX] == WALL) continue;
                if (copyVisited[nextY][nextX]) continue;

                copyRoom[nextY][nextX] = VIRUS;
                copyVisited[nextY][nextX] = true;
                queue.add(nextY);
                queue.add(nextX);
            }
        }

        int safeCount = getSafeCount(copyRoom);
        maxSafeCount = Math.max(maxSafeCount, safeCount);
    }

    private static int getSafeCount(int[][] array) {
        int safeCount = 0;

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if(array[i][j] == EMPTY)
                    safeCount++;
            }
        }

        return safeCount;
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // set n ,m
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        // init queue
        wall = new ArrayList<>();
        virus = new ArrayList<>();

        // set room
        room = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                room[i][j] = Integer.parseInt(st.nextToken());

                if (room[i][j] == WALL) {
                    wall.add(i);
                    wall.add(j);
                } else if (room[i][j] == VIRUS) {
                    virus.add(i);
                    virus.add(j);
                }
            }
        }

        // isVisited
        isVisited = new boolean[n][m];

        // maxSafeCount
        maxSafeCount = Integer.MIN_VALUE;
    }

}
