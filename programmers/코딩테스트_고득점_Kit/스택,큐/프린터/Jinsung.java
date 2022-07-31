import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<Integer> queue = new LinkedList<>();
        Queue<Integer> index = new LinkedList<>();
        // Queue에 priorities에 있는 숫자들을 담고, index에 priorities의 index를 담는다.
        for(int i=0;i<priorities.length;i++){
            queue.add(priorities[i]);
            index.add(i);
        }
        
        // queue가 모두 비어질때까지 순회하며 우선순위가 높은 문서를 먼저 출력한다.
        while(!queue.isEmpty()){
            // 만일 queue에 우선순위가 높은 문서와 현재 queue에 대기중인 문서의 우선순위가 같을경우 출력한다. 
            if(Collections.max(queue) == queue.peek()){
                answer++;
                if(index.peek()==location){
                    return answer; 
                }
                queue.remove();
                index.remove();
            }else{  // 문서들 중 우선순위가 더 높은것이 있다면 현 문서를 뒤로 보낸다.
                int num = queue.poll();
                int i = index.poll();
                queue.add(num);
                index.add(i);
            }
        }
        
        return answer;
    }
}