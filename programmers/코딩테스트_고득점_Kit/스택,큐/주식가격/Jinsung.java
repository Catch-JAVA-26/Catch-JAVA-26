import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Stack<Integer> s = new Stack<>();
        // 가장 처음 값을 stack 우선 넣는다.
        s.push(0);
        
        // 비교하는 값보다 큰 값이 stack 상위에 존재한다면, 현재위치에서 해당 위치의 차이를 answer에 저장한다.
        for(int i=1;i<prices.length;i++){
            // stack이 비어있지 않고 스택의 꼭대기 값 인덱스에 위치한 price가 현재 값보다 크다면, 현재위치에서 해당 위치의 차이를 answer에 저장 후 stack에서 제거
            while(!s.isEmpty()&&prices[s.peek()]>prices[i]){
                answer[s.peek()] = i-s.peek();
                s.pop();
            }
            // 비교하는 값의 index를 추가한다.
            s.push(i);
        }
        
        // stack에 있는 index를 순회하며, 주식가격이 떨어지지 않은 기간을 answer에 저장한다.
        for(int i=s.size();i>0;i--){
            answer[s.peek()] = prices.length-s.peek()-1;
            s.pop();
        }
        
        return answer;
    }
}