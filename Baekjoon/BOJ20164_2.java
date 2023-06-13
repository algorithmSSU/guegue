import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BOJ20164_2 {
    private static int n;
    private static int min, max;

    public static void main(String[] args) throws IOException {
        init();

        findMinAndMax(n, 0);

        System.out.print(min + " ");
        System.out.println(max);
    }

    /*
    임의의 3구간으로 나눠서 합산한 값이 담긴 list를 얻는다.
     */
    private static List<Integer> getListSumDividedByThree(int num) {
        List<Integer> list = new ArrayList<>();

        // process
        getSumDivideByThree(Integer.toString(num), 0, 1, new int[2], list);

        return list;
    }

    private static void getSumDivideByThree(String num, int count, int idx, int[] cutIdxArray, List<Integer> answerList) {
        if(count == 2){
            String num1Str = num.substring(0, cutIdxArray[0]);
            String num2Str = num.substring(cutIdxArray[0], cutIdxArray[1]);
            String num3Str = num.substring(cutIdxArray[1]);

            int sum = Integer.parseInt(num1Str) + Integer.parseInt(num2Str) + Integer.parseInt(num3Str);
            answerList.add(sum);
            return;
        }

        for(int i = idx; i < num.length(); i++){
            cutIdxArray[count] = i;
            getSumDivideByThree(num, count + 1, i + 1, cutIdxArray, answerList);
        }
    }

    private static void findMinAndMax(int num, int count) {
        // 홀수개수 갱신
        count += getOddNumCount(num);

        // 종료
        if (num < 10) {
            min = Math.min(min, count);
            max = Math.max(max, count);
            return;
        }

        // 2자리인 경우
        if (num < 100) {
            findMinAndMax((num / 10) + (num % 10), count);
        } // 3자리 이상인 경우
        else {
            List<Integer> list = getListSumDividedByThree(num);
            for(int sum : list){
                findMinAndMax(sum, count);
            }
        }
    }

    private static int getOddNumCount(int num) {
        int count = 0;
        while (num != 0) {
            int thisNum = num % 10;
            if (thisNum % 2 != 0) {
                count++;
            }
            num /= 10;
        }

        return count;
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        min = Integer.MAX_VALUE;
        max = Integer.MIN_VALUE;
    }

}

// 3자리 이상인 수를 3 개로 어떻게 분리할 것인가?


/*
82019

1. 홀수의 개수 count
2. 수가 한 자리면 break;
3. 수가 두 자리면 2개로 나눠서 합
4. 수가 세 자리 이상이면 임의의 위치에서 3개로 분리하고 3개를 더함
 */