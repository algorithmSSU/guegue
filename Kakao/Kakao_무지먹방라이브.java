import java.util.*;


class Kakao_무지먹방라이브 {
    public int solution(int[] food_times, long k) {
        /*
        LinkedList 초기화
        */
        List<Food> foodList = new LinkedList();
        long length = food_times.length;

        for(int i = 0; i < length; i++){
            foodList.add(new Food(food_times[i], i+1));
        }

        /*
        시간 순 정렬
        */
        foodList.sort(food_timeCompare);

        /*
        calculate
        */
        int idx = 0;
        int currentTime = 0;
        for(Food food : foodList){
            int diff = food.food_time - currentTime;
            // 이전과 높이차가 없는 경우 예외 처리
            if(diff != 0){
                long sum = diff * length;
                if(sum <= k){
                    k -= sum;
                    currentTime = food.food_time;
                }else{
                    k %= length;
                    foodList.subList(idx, food_times.length).sort(seqCompare);
                    return foodList.get(idx + (int)k).seq;
                }
            }
            idx++;
            length--;
        }
        return -1;
    }

    class Food{
        int seq;
        int food_time;

        Food(int food_time, int seq){
            this.seq = seq;
            this.food_time = food_time;
        }
    }

    Comparator<Food> food_timeCompare = new Comparator<Food>(){
        public int compare(Food a, Food b){
            return a.food_time - b.food_time;
        }
    };

    Comparator<Food> seqCompare = new Comparator<Food>(){
        public int compare(Food a, Food b){
            return a.seq - b.seq;
        }
    };
}



/*
1. 완전탐색으로 접근 -> 시간 초과 및 문제 해결 불가능
2. 답 봤는데 넘무 어려움 -> 음식 시간 순으로 정렬해서 계싼 ㅇㅋ 아니 근데 이 아이디어를 어떻게 생각해????????????????????


음식을 시간순으로 정렬
 */






/*
1.
class Solution {
    static int idx = 0;

    public int solution(int[] food_times, long k) {
        // k번 순회
        // toString(food_times);
        for(int i = 0 ; i < k; i++){
            // System.out.println("현재 idx is " + idx);
            eatFood(food_times);
            // toString(food_times);
        }

        // nextFoodIdx 출력
        nextFoodIdx(food_times);
        return idx + 1;
    }

    private void nextFoodIdx(int[] food_times){
        // 예외 처리
        if (idx == -1)
            idx = -1;

        // 0번인거 건너뛰고 다음 먹을 음식으로 이동
        // 배열 크기만큼 반복해도 못찾으면 -1로 초기화
        int arraySize = 0;
        while(true){
            if(arraySize++ == food_times.length){

                idx = -1;
                break;
            }

            idx += 1;

            // 배열 범위 넘어가면 0으로 초기화
            if(idx >= food_times.length)
                idx = 0;

            // 0이면 한 번 더 이동, 1 이상이면 종료
            if(food_times[idx] == 0)
                continue;
            else if(food_times[idx] >= 1)
                break;
        }

    }

    private void eatFood(int[] food_times){
        // 현재 인덱스에서 -1
        food_times[idx] -= 1;

        // nextFoodIdx 호출
        nextFoodIdx(food_times);
    }

    private void toString(int[] array){
        for(int i : array){
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
 */