package Sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ20291 {
    static int n;
    static Map<String, Integer> fileMap;

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        fileMap = new HashMap<>();

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), ".");
            st.nextToken();
            String fileName = st.nextToken();

            if(!fileMap.containsKey(fileName)){
                fileMap.put(fileName, 1);
            }else{
                fileMap.put(fileName, fileMap.get(fileName) + 1);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        input();

        process();
    }

    private static void process(){
        // key를 사전순으로 정렬
        List<Map.Entry<String, Integer>> list = new ArrayList<>(fileMap.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>(){
           @Override
           public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2){
               return o1.getKey().compareTo(o2.getKey());
           }
        });

        for(Map.Entry<String, Integer> map : list){
            System.out.println(map.getKey() + " " + map.getValue());
        }
    }
}
