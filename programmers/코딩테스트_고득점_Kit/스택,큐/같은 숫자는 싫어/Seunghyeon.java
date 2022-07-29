import java.util.*;
import java.util.stream.Collectors;

public class Solution {
    public int[] solution(int []arr) {
        Stack<Integer> s = new Stack<>();

        s.push(arr[0]);
        for (int n: arr) {
            if (s.peek() != n) {
                s.push(n);
            }
        }

        int[] answer = new int[s.size()];
        int i = 0;
        for (int n: s) {
            answer[i++] = n;
        }

        return answer;
    }
}