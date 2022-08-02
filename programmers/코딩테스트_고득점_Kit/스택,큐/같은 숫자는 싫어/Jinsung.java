import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        
        Stack<Integer> s = new Stack<>();
        // 첫번째 인덱스 숫자를 s에 쌓는다.
        s.push(arr[0]);
        // 다른 숫자가 등장할때만 s에 숫자를 쌓는다.
        for(int i=1;i<arr.length;i++){
            if(s.peek()!=arr[i]){
                s.push(arr[i]);
            }
        }
        
        int[] answer = new int[s.size()];
        int size = s.size();
        // 스택의 꼭대기부터 바닥까지 순회하며, answer에 담는다.
        for(int i=size-1;i>=0;i--){
            answer[i] = s.peek();
            s.pop();
        }
        
        return answer;
    }
}