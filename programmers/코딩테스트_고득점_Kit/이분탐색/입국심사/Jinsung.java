import java.util.*;
class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        // 최악의 상황일때 가장 심사 시간이 긴 심사대에서 모든 인원이 검사 받는것이므로 심사 시간을 오름차순으로 정렬한다.
        Arrays.sort(times);
        // 가장 최악의 시간을 right, 0시간을 left로 저장한다.
        long right = (long) times[times.length-1]*n;
        long left = 0;
        
        // 적절한 값을 찾을때까지(left가 right와 교차하는 순간) 반복문을 순회한다.
        while(left<=right){
            // 적절한 위치를 찾기 위해 최악과 최선을 더한 값의 중위값을 mid로 저장한다.
            long mid = (left+right)/2;
            long passenger = 0;
            // 해당 시간동안 각 심사대에서 처리할 수 있는 인원을 구한다.
            for(long t : times){
                passenger += mid/t;
                // 처리할 사람이 대기 인원을 초과할 경우 해당 시간은 답이 아니므로 반복문을 종료한다.
                if(passenger > n){
                    break;
                }
            }
            if(passenger >= n){  
                // 만일 처리한 인원이 대기 인원보다 크거나 같은 경우
                // 일단 해당 시간이 가장 짧은 시간일 수 있으므로 answer에 mid를 저장하고
                // 해당 시간보다 짧은 시간이 있을 수 있으므로 right에 mid-1한 값을 저장한다.
                right = mid-1;
                answer = mid;
            }else if(passenger < n){
                // 만일 처리한 인원이 대기 인원보다 작을 경우 해당 시간보다 긴 시간을 가지고 인원을 처리해야하므로 left에 mid+1를 저장한다.
                left = mid+1;
            }
        }
        
        return answer;
    }
}