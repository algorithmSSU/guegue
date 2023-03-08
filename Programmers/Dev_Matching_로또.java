import java.util.*;

class Dev_Matching_로또 {
    public int[] solution(int[] lottos, int[] win_nums) {
        // sort asc
        Arrays.sort(lottos);
        Arrays.sort(win_nums);

        // set zeroCount
        int zeroCount = 0;
        for(int i = 0 ; i < lottos.length; i++){
            if(lottos[i] == 0){
                zeroCount++;
            }else{
                break;
            }
        }

        // calculate
        int lottosIdx = zeroCount;
        int winIdx = 0;
        int sameCount = 0;
        while(lottosIdx < lottos.length && winIdx < win_nums.length){
            if(lottos[lottosIdx] == win_nums[winIdx]){
                sameCount++;
                lottosIdx++;
                winIdx++;
            }else if(lottos[lottosIdx] < win_nums[winIdx]){
                lottosIdx++;
            }else{
                winIdx++;
            }
        }

        // set rank
        Map<Integer, Integer> map = new HashMap<>();
        map.put(6, 1);
        map.put(5, 2);
        map.put(4, 3);
        map.put(3, 4);
        map.put(2, 5);
        map.put(1, 6);
        map.put(0, 6);

        // set answer
        int[] answer = new int[2];
        answer[1] = map.get(sameCount);
        answer[0] = map.get(sameCount + zeroCount);
        return answer;
    }
}


/**
 * 로또의 최고 순위와 최저 순위
 * https://school.programmers.co.kr/learn/courses/30/lessons/77484
 */