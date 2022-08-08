import java.util.ArrayList;

public class Programmers_targetNum {
    public static void main(String[] args) {
        System.out.println(solution((new int[] {4,1,2,1}), 4));
    }
    public static int solution(int[] numbers, int target) {
        int answer = 0;
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(0);

        for(int i : numbers){
            ArrayList<Integer> tmpList = new ArrayList<>();
            for(int j : arrayList){
                tmpList.add(j + i);
                tmpList.add(j - i);
            }
            arrayList = tmpList;
        }

        for(int i : arrayList){
            if(i == target)
                answer++;
        }
        return answer;
    }

}
