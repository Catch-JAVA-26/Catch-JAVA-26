class Solution {
    public int solution(int[][] sizes) {
        int maxHeight = 0;
        int maxWidth = 0;

        for (int[] size : sizes) {
            maxHeight = Math.max(maxHeight, Math.max(size[0], size[1]));
            maxWidth = Math.max(maxWidth, Math.min(size[0], size[1]));
        }

        return maxHeight * maxWidth;
    }
}
