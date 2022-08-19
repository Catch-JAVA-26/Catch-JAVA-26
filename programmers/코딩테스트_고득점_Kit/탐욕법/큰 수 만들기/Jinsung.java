import java.util.*;

class Solution {
    public String solution(String number, int k) {
        String answer = "";
        int numSize = number.length()-k;
        Stack<Character> stack = new Stack<>();
        // numbers의 끝까지 순회하며, 제거해야하는 숫자가 0이 될때 까지 큰 숫자만 남기고 작은 숫자가 있다면 제거한다.
        for(int i=0;i<number.length();i++){
            while(stack.size()>0 && stack.peek()-'0'<number.charAt(i)-'0' && k>0){
                stack.pop();
                k--;
            }
            // 만들어야하는 숫자보다 작을때만 stack에 집어 넣는다.
            if(stack.size() < numSize)
                stack.push(number.charAt(i));
        }
        // stack의 모든 문자를 answer에 붙힌다.
        for(Character c : stack){
            answer += c;
        }
        return answer;
    }
}