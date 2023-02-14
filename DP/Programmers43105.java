public class Programmers43105 {
    class Solution {
        private int[][] dp;

        private void init(int[][] triangle){
            // init dp
            dp = new int[triangle.length][];
            for(int i = 0; i < triangle.length; i++){
                dp[i] = new int[triangle[i].length];
            }
        }

        public int solution(int[][] triangle) {
            init(triangle);

            // set dp
            setDp(triangle);

            // set max
            int max = 0;
            for(int i = 0 ; i < dp.length; i++){
                for(int j = 0 ; j < dp[i].length; j++){
                    max = Math.max(max, dp[i][j]);
                }
            }

            // return
            return max;
        }

        private void setDp(int[][] triangle){
            // set init
            dp[0][0] = triangle[0][0];

            // set others
            for(int i = 1; i < triangle.length; i++){
                for(int j = 0 ; j < triangle[i].length; j++){
                    int leftParent = j-1;
                    int rightParent = j;

                    //set sum
                    int leftParentValue = -1;
                    int rightParentValue = -1;
                    if(leftParent >= 0 && leftParent < triangle[i-1].length) leftParentValue = dp[i-1][leftParent];
                    if(rightParent >= 0 && rightParent < triangle[i-1].length) rightParentValue = dp[i-1][rightParent];

                    // set element
                    dp[i][j] = Math.max(leftParentValue, rightParentValue) + triangle[i][j];
                }
            }
        }
    }
}


