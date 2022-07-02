import java.util.*;
import java.io.*;

public class BaekJoon_2023_DFS {
    static ArrayList<Integer> answer = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        i_primeNum(N);

        for(int i = 0; i < answer.size(); i++){
            System.out.println(answer.get(i));
        }

    }
    private static void i_primeNum(int targetDigitNum){   //digitNum -> 자릿수
        dfs(2, 1, targetDigitNum);
        dfs(3, 1, targetDigitNum);
        dfs(5, 1, targetDigitNum);
        dfs(7, 1, targetDigitNum);
    }

    private static void dfs(int num, int digitNum, int targetDigitNum){
        // 자리수가 target이면 -> 소수일 땐 add 후 return, 아니면 그냥 return
        // 재귀 종료 조건
        if(digitNum == targetDigitNum){
            if(primeNum(num)){
                answer.add(num);
            }else{
                return;
            }
        }

        //다음 자리 수 가지고 dfs 할 조건
        for(int i = 1; i < 10; i += 2){
            int next = num * 10 + i;
            if(primeNum(num)){
                dfs(next, digitNum+1, targetDigitNum);
            }
        }
    }

    private static boolean primeNum(int num){
        for(int i = 2; i <= num / 2; i++){
            if(num % i == 0)
                return false;
        }
        return true;
    }
}

/*
[Key Point]
1의 자리수가 짝수면 소수가 될 수 없음 -> i++이 아닌 i += 2


 */







/*
[Specification]
수빈이가 세상에서 가장 좋아하는 것은 소수이고, 취미는 소수를 가지고 노는 것이다. 요즘 수빈이가 가장 관심있어 하는 소수는 7331이다.
7331은 소수인데, 신기하게도 733도 소수이고, 73도 소수이고, 7도 소수이다. 즉, 왼쪽부터 1자리, 2자리, 3자리, 4자리 수 모두 소수이다! 수빈이는 이런 숫자를 신기한 소수라고 이름 붙였다.
수빈이는 N자리의 숫자 중에서 어떤 수들이 신기한 소수인지 궁금해졌다. N이 주어졌을 때, 수빈이를 위해 N자리 신기한 소수를 모두 찾아보자.

Input
첫째 줄에 N(1 ≤ N ≤ 8)이 주어진다.

Output
N자리 수 중에서 신기한 소수를 오름차순으로 정렬해서 한 줄에 하나씩 출력한다.
 */
