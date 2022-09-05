class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        int length = triangle.length;
        int[][] dp = new int[length][];

        dp[0] = new int[1];
        dp[0][0] = triangle[0][0];

        for (int i=1; i<length; i++) {
            dp[i] = new int[i+1];
            dp[i][0] = dp[i-1][0] + triangle[i][0];
            dp[i][i] = dp[i-1][i-1] + triangle[i][i];
            for (int j=1; j<i; j++) {
                dp[i][j] = Math.max(dp[i-1][j] + triangle[i][j], dp[i-1][j-1] + triangle[i][j]);
            }
        }

        for (int i=0; i<length; i++) {
            answer = Math.max(answer, dp[length-1][i]);
        }

        return answer;
    }
}