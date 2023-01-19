package TwoPointers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ2470 {
    static int n;
    static int[] array;

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        array = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < array.length; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }
    }

    public static void main(String[] args) throws IOException {
        input();

        process();
    }

    private static void process(){
        // ascending sort
        Arrays.sort(array);

        int left = 0;
        int right = array.length-1;
        int minLeft = -1;
        int minRight = -1;
        int nearestZero = Integer.MAX_VALUE;

        while(left != right){
            int sum = array[left] + array[right];

            // 즉시 종료 조건
            if(sum == 0){
                minLeft = array[left];
                minRight = array[right];
                break;
            }

            // 저장 여부 결정
            if(Math.abs(sum) < nearestZero){
                nearestZero = Math.abs(sum);
                minLeft = array[left];
                minRight = array[right];
            }


            if(sum < 0){
                left++;
            }else{
                right--;
            }
        }

        System.out.println(minLeft + " " + minRight);

    }
}


/**
 * Binary Search를 통해서 푸는 방법
 1. 정렬
 2. 0에 가까운 원소 찾기 위해서 현재 원소에 -1곱하고 가장 가까운 요소 찾음
 3. 서로 더해서 최소면 갱신


 * Two Pointer 이용
 1. 정렬
 2. 양 끝점이 최소, 최대임
 3. 최소 + 최대 < 0이면 최소 삭제 후 최소idx++;
 4. 최소 + 최대 > 0이면 최대 삭제 후 최대idx--;
 5. 삭제하면서 최소 + 최대랑 answer 비교 후 0에 가까우면 갱신
 **/