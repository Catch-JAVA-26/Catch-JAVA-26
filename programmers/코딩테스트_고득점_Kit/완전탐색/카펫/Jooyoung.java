class Solution {
    public int[] solution(int brown, int yellow) {
        int sum = brown + yellow;

        for (int i = 3; i <= sum; i++) {
            if (sum % i == 0) {
                int col = sum / i;
                int row = sum / col;

                if ((col - 2) * (row - 2) == yellow) {
                    return new int[]{col, row};
                }
            }
        }
        return new int[]{};
    }
}
