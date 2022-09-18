import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        
        // 심사 시간의 대상이 될 시간을 저장 할 HashSet을 선언한다.
        HashSet<Long> candidate = new HashSet<Long>();
        
        // n명이 한 심사대에서 심사 받았을때의 시간을 candidate에 저장한다.
        for(long i=1;i<=n;i++){
            for(int person = 0; person<times.length;person++){
                long c = times[person] * i;    
                candidate.add(c);
            }
        }
        
        // HashSet은 순서 보장이 되지 않기 때문에, long 배열로 변경 후 정렬을 한다.
        Long[] candidateArr = candidate.toArray(new Long[0]);
        Arrays.sort(candidateArr);
        
        long passenger = 0;
        
        // 후보 시간을 하나씩 확인하며, 해당 시간안에 통과시킬 수 있는 인원이 n과 같으면 해당 값을 반환한다.
        for(long c : candidateArr){
            for(int p = 0; p<times.length;p++){
                passenger += c/times[p];
            }
            if(passenger == n){
                answer = c;
                break;
            }else{
                passenger = 0;
            }
        }
        
        return answer;
    }
}