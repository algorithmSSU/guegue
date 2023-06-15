import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ1138 {
    private static int n;
    private static Map<Integer, Integer> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        init();

        // value 기준으로 오름차순 정렬
        List<Map.Entry<Integer, Integer>> mapList = new ArrayList<>(map.entrySet());
        Collections.sort(mapList, new Comparator<Map.Entry<Integer, Integer>>() {
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o1.getValue() - o2.getValue();
            }
        });

        // set answerList
        List<Integer> answerList = new ArrayList<>();
        answerList.add(mapList.get(0).getKey());

        for (int i = 1; i < mapList.size(); i++) {
            int thisKey = mapList.get(i).getKey();
            int thisValue = mapList.get(i).getValue();

            int count = 0;
            boolean inserted = false;
            for (int j = 0; j < answerList.size(); j++) {
                if(thisKey < answerList.get(j)){
                    count++;
                }

                if(count > thisValue){
                    answerList.add(j, thisKey);
                    inserted = true;
                    break;
                }
            }

            if(!inserted){
                answerList.add(thisKey);
            }
        }

        // print answer
        for(int num : answerList){
            System.out.print(num + " ");
        }
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            map.put(i + 1, Integer.parseInt(st.nextToken()));
        }
    }
}



/*
1 => 2
2 => 1
3 => 1
4 => 0

1 => 5
2 => 4
3 => 3
4 => 2
5 => 1
6 => 0


6 => 0
7 => 0
2 => 1
3 => 1
4 => 1
5 => 2
1 => 6

6 2 3 4 7 5 1

6 2 7



 */
