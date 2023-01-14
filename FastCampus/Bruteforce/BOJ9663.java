package Bruteforce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ9663 {
    private static int n, count;
    private static List<Integer> queenList;

    public static void main(String[] args) throws IOException {
        input();

        queenSearch(0, queenList);

        System.out.println(count);
    }

    private static void queenSearch(int currentRow, List<Integer> queenList) {
        // 모든 체스판 검사한 경우 : 퀸을 n개 놓음
        if (currentRow == n) {
            count++;
            return;
        }

        for (int col = 0; col < n; col++) {
            // 퀸 현재 자리에 놓을 수 있는 지 체크
            if (checkAvailable(col, queenList)) {
                // 놓을 수 있으면 recursive call
                queenList.add(col);
                queenSearch(currentRow + 1, queenList);

                // recursive call 끝나고 돌아온 경우 queenList에서 지워주기
                queenList.remove(queenList.size() - 1);
            }
        }
    }

    private static boolean checkAvailable(int thisCol, List<Integer> list) {
        int thisRow = list.size();

        for (int i = 0; i < list.size(); i++) {
            int queenElementRow = i;
            int queenElementCol = list.get(i);

            // 같은 열인지 체크
            if (thisCol == queenElementCol)
                return false;

            // 대각선인지 체크
            if (Math.abs(queenElementRow - thisRow) == Math.abs(queenElementCol - thisCol))
                return false;
        }

        return true;
    }


    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        count = 0;

        queenList = new ArrayList<>();
    }

}




/*
<N-Queens>

일단 O(N^2) 시간복잡도는 불가능 -> 최대값 바탕으로 계산해보면 10억 번 연산 넘어감
 */










/*
    static int n;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        input();

        dfs(0, new ArrayList<Integer>());

        System.out.println(count);
    }

    private static void dfs(int currentRow, List<Integer> list) {
        // 완성본
        if (currentRow == n) {
            count++;
            return;
        }

        for (int col = 0; col < n; col++) {
            if (checkAvailable(col, list)) {
                // 리스트에 column 추가하고 recursive call
                list.add(col);
                dfs(currentRow + 1, list);
                list.remove(list.size() - 1);
            }
        }

    }

private static boolean checkAvailable(int currentCol, List<Integer> list) {
    int currentRow = list.size();

    // col 계산
    for (int i = 0; i < list.size(); i++) {
        int thisListCol = list.get(i);
        if (currentCol == thisListCol)
            return false;
    }

    // 대각선 계산
    for (int i = 0; i < list.size(); i++) {
        int thisListCol = list.get(i);
        int thisListRow = i;
        if (Math.abs(currentCol - thisListCol) == Math.abs(currentRow - thisListRow))
            return false;
    }

    return true;
}


    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
    }
 */