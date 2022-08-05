import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;

        Arrays.sort(citations);

        for (int i=0, cnt=citations.length; i<citations.length; i++, cnt--) {
            if (citations[i] >= cnt) {
                answer = cnt;
                break;
            }
        }

        return answer;
    }
}