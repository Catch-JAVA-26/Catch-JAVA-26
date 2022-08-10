import java.util.*;

class Solution {
    public int solution(int[] citations) {
        Arrays.sort(citations);

        int min = 0, max = 0;
        for (int i = citations.length - 1; i > -1; i--){
            min = Math.min(citations[i], citations.length - i);
            max = Math.max(max, min);
        }

        return max;
    }
}
