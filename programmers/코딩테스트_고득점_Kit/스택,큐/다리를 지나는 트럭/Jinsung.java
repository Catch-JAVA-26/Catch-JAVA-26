import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        Queue<Integer> bridge = new LinkedList<>();
        Queue<Integer> spent_bridge = new LinkedList<>();
        Queue<Integer> wait = new LinkedList<>();
        Queue<Integer> pass = new LinkedList<>();
        
        // truck_weights의 차량을 wait queue로 이동
        for(int i=0;i<truck_weights.length;i++){
            wait.add(truck_weights[i]);
        }
        
         while(pass.size() != truck_weights.length){
        	 // 다리에 있는 차를 내린다.
             spent_bridge = plusAll(spent_bridge);
             // 경과시간을 담은 stack에 원소가 있다면 확인
             if(!spent_bridge.isEmpty()) {
                 // 만일 경과시간의 맨 앞 숫자가 다리의 길이보다 길 경우 퇴출(다리를 지난 트럭으로 이동)
            	 if(spent_bridge.peek()>=bridge_length){
            		 pass.add(bridge.poll());
                     spent_bridge.remove();
                 }
             }
        	 // 시간 증가
             answer++;
             // 대기 트럭이 존재하고, 
             // 다리를 건너는 트럭의 길이+1보다 다리의 길이가 작거나 같을경우
             // 다리위에 있는 트럭의 무게+다음 대기 트럭의 무게가 다리의 하중보다 작거나 같을경우 차를 올려보낸다.
             if(!wait.isEmpty()&&bridge.size()+1<=bridge_length && calculateSum(bridge)+wait.peek()<=weight){
                 // 다리에 새로운 차를 올린다.
                 int car = wait.poll();
                 bridge.add(car);
                 spent_bridge.add(0);
             }     
        }
        
        return answer;
    }
    
    public int calculateSum(Queue<Integer> q){
        int sum = 0;
        for(int n : q) {
        	sum += n;
        }
        return sum;
    }
    
    public Queue<Integer> plusAll(Queue<Integer> q){
        for(int i=0;i<q.size();i++) {
        	q.add(q.poll()+1);
        }
        return q;
    }
}