import java.io.*;
import java.util.*;

public class BOJ15686_2 {
    private static final int EMPTY = 0, HOME = 1, CHICKEN = 2;
    private static int n, m, minChickenDistanceInCity;
    private static int[][] array;
    private static List<Integer> chickenList = new ArrayList<>();
    private static List<Integer> tmpChickenList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        init();

        // process
        selectChickenAndUpdate(0, 0);

        // print Answer
        System.out.println(minChickenDistanceInCity);
    }

    private static void selectChickenAndUpdate(int selectCount, int idx){
        if(selectCount == m){
            int nowChickenDistanceInCity = getChickenDistanceInCity();
            minChickenDistanceInCity = Math.min(minChickenDistanceInCity, nowChickenDistanceInCity);
            return;
        }

        for(int i = idx; i < chickenList.size(); i += 2){
            array[chickenList.get(i)][chickenList.get(i + 1)] = CHICKEN;
            tmpChickenList.add(chickenList.get(i));
            tmpChickenList.add(chickenList.get(i + 1));
            selectChickenAndUpdate(selectCount + 1, i + 2);
            tmpChickenList.remove(tmpChickenList.size() - 1);
            tmpChickenList.remove(tmpChickenList.size() - 1);
            array[chickenList.get(i)][chickenList.get(i + 1)] = EMPTY;
        }
    }

    private static int getChickenDistanceInCity(){
        int sum = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0 ; j < n ; j++){
                if(array[i][j] == HOME){
                    sum += getChickenDistance(i, j);
                }
            }
        }
        return sum;
    }

    private static int getChickenDistance(int y, int x){
        int distance = Integer.MAX_VALUE;
        for(int i = 0 ; i < tmpChickenList.size(); i += 2){
            int height = Math.abs(y - tmpChickenList.get(i));
            int width = Math.abs(x - tmpChickenList.get(i + 1));
            distance = Math.min(distance, (height + width));
        }
        return distance;
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // set n, m
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        // set array
        array = new int[n][n];
        for(int i = 0 ; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < n; j++){
                array[i][j] = Integer.parseInt(st.nextToken());

                // set chickenList
                if(array[i][j] == CHICKEN){
                    chickenList.add(i);
                    chickenList.add(j);
                    array[i][j] = EMPTY;
                }
            }
        }

        // init
        minChickenDistanceInCity = Integer.MAX_VALUE;
    }

    private static void debugPrintArray(int[][] array){
        for(int[] i : array){
            for(int j : i){
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }
}


/*
가정
1. 무조건 M개 고르는 경우가 도시의 치킨 거리가 제일 작을 것임

process
1. 전체 치킨 리스트 init
2. dfs 돌려가며 m개 선택
3. 선택해서 치킨 거리 각각 구하고 최소 치킨 거리 update
4. 출력
 */