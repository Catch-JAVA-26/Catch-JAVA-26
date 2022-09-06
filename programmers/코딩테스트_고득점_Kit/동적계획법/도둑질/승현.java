import java.util.Arrays;

class Solution {
    public int solution(int[] money) {
        int[] excludeLast = Arrays.copyOfRange(money, 0, money.length-1);
        int[] excludeFirst = Arrays.copyOfRange(money, 1, money.length);

        excludeLast[1] = Math.max(excludeLast[0], excludeLast[1]);
        excludeFirst[1] = Math.max(excludeFirst[0], excludeFirst[1]);

        for (int i=2; i<money.length-1; i++) {
            excludeLast[i] = Math.max(excludeLast[i-1], excludeLast[i-2] + excludeLast[i]);
            excludeFirst[i] = Math.max(excludeFirst[i-1], excludeFirst[i-2] + excludeFirst[i]);
        }

        return Math.max(excludeLast[money.length-2], excludeFirst[money.length-2]);
    }
}