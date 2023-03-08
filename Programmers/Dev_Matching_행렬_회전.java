import java.util.*;

class Dev_Matching_행렬_회전 {
    int[][] direction = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}}; // 하 상 좌 우
    List<Integer> answerList;
    int[][] matrix;

    public int[] solution(int rows, int columns, int[][] queries) {
        init(rows, columns);

        // add answerList
        for(int i = 0; i < queries.length; i++){
            int minValue = rotateAndfindMinValue(queries[i]);
            answerList.add(minValue);
        }

        // set answer
        int[] answer = new int[answerList.size()];
        for(int i = 0 ; i < answerList.size(); i++){
            answer[i] = answerList.get(i);
        }

        return answer;
    }

    private void init(int row, int columns){
        // set answerList
        answerList = new ArrayList<>();

        // set matrix
        matrix = new int[row+1][columns+1];
        int count = 1;
        for(int y = 1; y <= row; y++){
            for(int x = 1; x <= columns; x++){
                matrix[y][x] = count++;
            }
        }
    }

    /*
    시계방향 회전 시키기
    return 사각형 가장자리 중 최소값
    */
    private int rotateAndfindMinValue(int[] query){
        int height = query[2] - query[0] + 1;
        int width = query[3] - query[1] + 1;
        int nowY = query[0];
        int nowX = query[1];
        int lastValue = -1;
        int minValue = Integer.MAX_VALUE;

        // move right
        for(int i = 0; i < width; i++){
            int nowValue = matrix[nowY][nowX];
            // min check
            if(nowValue != -1)
                minValue = (nowValue < minValue) ? nowValue : minValue;

            matrix[nowY][nowX] = lastValue;
            lastValue = nowValue;

            if(i != width - 1){
                nowY += direction[3][0];
                nowX += direction[3][1];
            }
        }

        // move down
        nowY += direction[0][0];
        nowX += direction[0][1];
        for(int i = 0 ; i < height - 1; i++){
            int nowValue = matrix[nowY][nowX];
            // min check
            if(nowValue != -1)
                minValue = (nowValue < minValue) ? nowValue : minValue;

            matrix[nowY][nowX] = lastValue;
            lastValue = nowValue;

            if(i != height - 2){
                nowY += direction[0][0];
                nowX += direction[0][1];
            }
        }

        // move left
        nowY += direction[2][0];
        nowX += direction[2][1];
        for(int i = 0 ; i < width - 1; i++){
            int nowValue = matrix[nowY][nowX];
            // min check
            if(nowValue != -1)
                minValue = (nowValue < minValue) ? nowValue : minValue;

            matrix[nowY][nowX] = lastValue;
            lastValue = nowValue;

            if(i != width - 2){
                nowY += direction[2][0];
                nowX += direction[2][1];
            }
        }

        // move up
        nowY += direction[1][0];
        nowX += direction[1][1];
        for(int i = 0 ; i < height - 1; i++){
            int nowValue = matrix[nowY][nowX];
            // min check
            if(nowValue != -1)
                minValue = (nowValue < minValue) ? nowValue : minValue;

            matrix[nowY][nowX] = lastValue;
            lastValue = nowValue;

            if(i != height - 2){
                nowY += direction[1][0];
                nowX += direction[1][1];
            }
        }

        return minValue;
    }

    private void printMatrix(){
        for(int i = 1; i < matrix.length; i++){
            for(int j = 1; j < matrix[i].length; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}


/**
 * 행렬 테두리 회전하기
 * https://school.programmers.co.kr/learn/courses/30/lessons/77485
 */
