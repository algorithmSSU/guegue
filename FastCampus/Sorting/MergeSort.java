package Sorting;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        // testing
        int[] arr = new int[100];
        for(int i = 0 ; i < arr.length; i++){
            arr[i] = (int)(Math.random() * 100);
        }

        // print
        int[] mergedArray = splitMerge(arr);
        int count = 1;
        for (int i : mergedArray){
            if(count++ % 10 == 0){
                System.out.println();
            }
            System.out.print(i + " ");
        }

    }

    // merge
    private static int[] merge(int[] back, int[] front) {
        int[] answer = new int[back.length + front.length];
        int answerIdx = 0;

        int backIdx = 0;
        int frontIdx = 0;
        // 앞뒤 배열 둘 다 순회 남은 경우
        while (backIdx < back.length && frontIdx < front.length) {
            if (back[backIdx] < front[frontIdx])
                answer[answerIdx++] = back[backIdx++];
            else
                answer[answerIdx++] = front[frontIdx++];
        }

        // 앞 배열 순회 남은 경우
        while (backIdx < back.length) {
            answer[answerIdx++] = back[backIdx++];
        }

        // 뒤 배열 순회 남은 경우
        while (frontIdx < front.length) {
            answer[answerIdx++] = front[frontIdx++];
        }

        // return
        return answer;
    }


    // split 후 return merge()
    private static int[] splitMerge(int[] array) {
        // 최소 단위로 나눠진 경우
        if (array.length < 2)
            return array;

        int mid = array.length / 2;
        int[] back = splitMerge(Arrays.copyOfRange(array, 0, mid));
        int[] front = splitMerge(Arrays.copyOfRange(array, mid, array.length));

        return merge(back, front);
    }
}



/*
merge sort
- 가장 작게 분리 후 병합하면서 정렬해감
- 1. split (분할), 2. merge (병합)
- 양쪽에 포인터 두고 하나하나 옮겨가며 최종 정렬하기


Implementation
1. 배열 2개를 merge 해주는 메소드 생성
2. 하나의 배열이 들어왔을 때 재귀적으로 왼쪽 오른쪽 배열로 나눠주다가 최소 단위가 되면 merge해주는 메소드
 */
