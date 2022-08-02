import java.util.*;
class Solution {
    boolean solution(String s) {
        // 괄호를 담을 stack을 선언
        Stack<Character> stack = new Stack();
        
        // String을 순회하며 '('일 경우 스택을 하나 쌓고, ')'일 경우 stack 하나를 뺀다.
        // 만일 ')'를 만났는데 stack이 비어있을경우 올바른 괄호가 아니므로 false를 return 한다.
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == '('){
                stack.push('(');
            }else{
                if(!stack.isEmpty()){
                    stack.pop();    
                }else{
                    return false;
                }
            }
        }
        
        return stack.isEmpty() ? true : false;
    }
}