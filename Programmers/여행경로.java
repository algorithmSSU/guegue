import java.util.*;

class 여행경로 {
    boolean[] isUsed;
    List<String> pathList;

    public String[] solution(String[][] tickets) {
        init(tickets.length);

        dfs(0, "ICN", "ICN", tickets);

        Collections.sort(pathList);

        return pathList.get(0).split(" ");
    }

    private void init(int n) {
        pathList = new ArrayList<>();
        isUsed = new boolean[n];
    }

    private void dfs(int depth, String recordCity, String nowCity, String[][] tickets) {
        if (depth == (tickets.length)) {
            pathList.add(recordCity);
            return;
        }

        for (int i = 0; i < tickets.length; i++) {
            if (!isUsed[i] && tickets[i][0].equals(nowCity)) {
                isUsed[i] = true;
                dfs(depth + 1, recordCity + " " + tickets[i][1], tickets[i][1], tickets);
                isUsed[i] = false;
            }
        }
    }
}



// https://school.programmers.co.kr/learn/courses/30/lessons/43164
