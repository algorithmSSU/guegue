import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ11652_2 {
    private static int n;
    private static Map<Long, Integer> map = new HashMap<>();
    public static void main(String[] args) throws IOException {
        init();

        List<Map.Entry<Long, Integer>> mapList = new ArrayList<>(map.entrySet());
        Collections.sort(mapList, new Comparator<Map.Entry<Long, Integer>>(){
            public int compare(Map.Entry<Long, Integer> o1, Map.Entry<Long, Integer> o2){
                if(o2.getValue().equals(o1.getValue())){
                    return Long.compare(o1.getKey(), o2.getKey());
                }
                return Integer.compare(o2.getValue(), o1.getValue());
            }
        });
//        System.out.println(mapList);

        System.out.println(mapList.get(0).getKey());
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        for(int i = 0 ; i < n ; i++){
            Long key = Long.parseLong(br.readLine());
            map.put(key, map.getOrDefault(key, 0) + 1);
        }
    }
}
