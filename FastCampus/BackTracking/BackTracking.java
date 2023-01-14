package BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BackTracking {
    public static void main(String[] args) {
        int n = 4;

        nQueensPrint(n, 0, new ArrayList<>());
    }

    private static void nQueensPrint(int n, int currentRow, List<Integer> list) {
        // 모든 행 탐색한 경우 종료
        if (n == currentRow) {
            System.out.println(list);
            return;
        }

        // 현재 row에서 각 col loop
        for (int i = 0; i < n; i++) {
            int currentCol = i;

            // 현재 행, 열의 놓을 수 있는 경우
            if (checkQueenAvailable(currentCol, list)) {
                list.add(currentCol);
                nQueensPrint(n, currentRow + 1, list);
                list.remove(list.size() - 1);
            }
        }
    }

    private static boolean checkQueenAvailable(int currentCol, List<Integer> list) {
        int currentRow = list.size();

        // loop
        for (int i = 0; i < list.size(); i++) {
            // 같은 열인지 체크
            int thisListElementRow = i;
            int thisListElementCol = list.get(i);
            if (currentCol == thisListElementCol)
                return false;

            // 대각선인지 체크
            if (Math.abs(currentRow - thisListElementRow) == Math.abs(currentCol - thisListElementCol))
                return false;
        }

        return true;
    }
}


/*
후보군 탐색할 때 DFS 사용 ex. N-Queens 문제
 */