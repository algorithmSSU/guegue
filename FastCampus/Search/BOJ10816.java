package Search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ10816 {
    static int n, targetNum;
    static int[] targetArray;
    static Map<Integer, Integer> numMap = new HashMap<>();
    static Set<Integer> set;



    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        // initialize numMap
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (!numMap.containsKey(num)) {
                numMap.put(num, 1);
            } else {
                numMap.put(num, numMap.get(num) + 1);
            }
        }

        // initialize set
        set = new HashSet<>(numMap.keySet());

        // initialize targetArray
        targetNum = Integer.parseInt(br.readLine());
        targetArray = new int[targetNum];
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < targetNum; i++){
            targetArray[i] = Integer.parseInt(st.nextToken());
        }
    }

    public static void main(String[] args) throws IOException {
        input();

        process();
    }

    private static void process(){
        StringBuilder sb = new StringBuilder();

        for(int i = 0 ; i < targetArray.length; i++){
            if(set.contains(targetArray[i])){
                sb.append(numMap.get(targetArray[i])).append(" ");
            }else
                sb.append(0).append(" ");
        }

        System.out.println(sb.toString());
    }

}
/*
map에 받기
set 공간 추가 할당해서 set 변환
contains로 해당 key 존재하면 map에서 get key
 */