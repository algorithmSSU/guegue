import java.util.*;
import java.io.*;

// https://www.acmicpc.net/problem/2018
public class BOJ2018 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int i = 0, j = 0;
        long count = 0;
        long sum = 0;
        while (i <= j || j < n) {
            if (sum < n) {
                j++;
                sum += j;
            } else if (sum > n) {
                sum -= i;
                i++;
            } else {
                count++;
                j++;
                sum += j;
            }
        }

        System.out.println(count);
    }
}

/*
[문제] 수들의 합 5
n 이하의 자연수 순서대로 loop 돌면 정렬되어있는 상태이니 two pointer 사용해서 개수 찾기 O(N)

n이 1000만까지 되므로 O(n^2)은 절대 안됨..!


아... 실수한 부분...
저번 문제랑 혼용해서 long으로 풀었음... int로 충분함
N이 1000만이고 구간합이 N인 경우 구하는 거니까 투포인터 사용해서 얼추 0 ~ 2000만 근처일 거임.. intintintintintintintintinti
 */
