import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;
        Stack<Character> stack = new Stack<>();

        for (int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                stack.push(ch);
            } else {
                if (!stack.empty()) {
                    stack.pop();
                } else {
                    answer = false;
                    break;
                }
            }
        }

        if (!stack.empty()) {
            answer = false;
        }

        return answer;
    }
}