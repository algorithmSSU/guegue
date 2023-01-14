package Sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ11652 {
    static int N;
    static Map<Long, Integer> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        input();

        // map의 value 기준 내림차순 정렬
        List<Map.Entry<Long, Integer>> mapEntryList = new ArrayList<>(map.entrySet());
        Collections.sort(mapEntryList, new Comparator<Map.Entry<Long, Integer>>(){
            @Override
            public int compare(Map.Entry<Long, Integer> o1, Map.Entry<Long, Integer> o2){
                if(o1.getValue().equals(o2.getValue())){
                    return Long.compare(o1.getKey(), o2.getKey());
                }
                return o2.getValue() - o1.getValue();
            }
        });


        // print
        System.out.println(mapEntryList.get(0).getKey());
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        // initialize map
        for(int i = 0; i < N; i++){
            long num = Long.parseLong(br.readLine());
            if(!map.containsKey(num)){
                map.put(num, 0);
            }else{
                map.put(num, map.get(num) + 1);
            }
        }
    }
}


/*
hashmap 안쓰고 그냥 배열로만 풀어보기
https://www.acmicpc.net/problem/11652


비슷한 문제로 20291도 풀어보기
 */