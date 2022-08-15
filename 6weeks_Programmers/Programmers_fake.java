import java.util.HashMap;
import java.util.Map;

public class Programmers_fake {
    public static void main(String[] args) {
        String[][] tmp = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
        System.out.println(solution(tmp));
    }

    public static int solution(String[][] clothes) {
        Map<String, Integer> map = new HashMap<>();
        for (String[] items : clothes) {
            String kind = items[1];
            if (map.containsKey(kind))
                map.put(kind, map.get(kind) + 1);
            else
                map.put(kind, 1);
        }

        int answer = 1;
        for (String key : map.keySet()) {
            answer *= (map.get(key)+1);
        }
        return answer - 1;
    }
}
