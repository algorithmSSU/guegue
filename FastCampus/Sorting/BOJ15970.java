package Sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ15970 {
    static int n, arrowSum;
    static Map<Integer, List<Integer>> dotMap;

    private static void input() throws IOException {
        dotMap = new HashMap<>();

        arrowSum = 0;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int idx = Integer.parseInt(st.nextToken());
            int color = Integer.parseInt(st.nextToken());

            List<Integer> idxList;
            if (!dotMap.containsKey(color)) {
                idxList = new ArrayList<>();
                idxList.add(idx);
                dotMap.put(color, idxList);
            } else {
                idxList = dotMap.get(color);
                idxList.add(idx);
                dotMap.put(color, idxList);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        input();

        process();

        // print
        System.out.println(arrowSum);
    }

    private static void process() {
        // color 별로 ascending sort
        for (int color : dotMap.keySet()) {
            List<Integer> idxList = dotMap.get(color);
            Collections.sort(idxList);
        }

        for (int color : dotMap.keySet()) {
            List<Integer> thisIdxList = dotMap.get(color);
            for (int i = 0; i < thisIdxList.size(); i++) {
                arrowSum += getMinArrow(thisIdxList, i);
            }
        }
    }

    private static int getMinArrow(List<Integer> list, int idx) {
        if (idx == 0) {
            return list.get(1) - list.get(0);
        }

        if (idx== (list.size() - 1)) {
            return list.get(list.size() - 1) - list.get(list.size() - 2);
        }

        int leftSum = list.get(idx) - list.get(idx-1);
        int rightSum = list.get(idx+1) - list.get(idx);
        return Math.min(leftSum, rightSum);
    }
}





/*
    static int n, arrowSum;
    static Map<Integer, List<Integer>> dotMapList = new HashMap<>();

    public static void main(String[] args) throws IOException {
        input();

        // ascending sorting
        for (Integer key : dotMapList.keySet()) {
            Collections.sort(dotMapList.get(key));
        }

        // calculate arrowSum
        calculate();

        // print
        System.out.println(arrowSum);
    }

    private static void calculate() {
        for (Integer key : dotMapList.keySet()) {
            List<Integer> thisList = dotMapList.get(key);

            // 처음과 끝 화살표 길이 따로 계산
            arrowSum += (thisList.get(1) - thisList.get(0));
            arrowSum += (thisList.get(thisList.size() - 1) - thisList.get(thisList.size() - 2));


            // idx 1 ~ (마지막-1)
            for (int i = 1; i < thisList.size() - 1; i++) {
                // 뒷방향
                int backLength = thisList.get(i) - thisList.get(i - 1);
                // 앞방향
                int frontLength = thisList.get(i + 1) - thisList.get(i);

                arrowSum += Math.min(backLength, frontLength);
            }
        }
    }


    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());

        arrowSum = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int idx = Integer.parseInt(st.nextToken());
            int color = Integer.parseInt(st.nextToken());
            List<Integer> list;

            if (dotMapList.containsKey(color)) {
                list = dotMapList.get(color);
                list.add(idx);
                dotMapList.put(color, list);
            } else {
                list = new ArrayList<>();
                list.add(idx);
                dotMapList.put(color, list);
            }
        }
    }
 */