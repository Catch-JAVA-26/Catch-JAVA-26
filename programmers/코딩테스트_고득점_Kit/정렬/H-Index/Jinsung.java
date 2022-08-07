import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        
        Arrays.sort(citations);
        int min = 0;
        int max = citations[citations.length-1];
        int[] candidate = new int[max-min+1];
        
        for(int loop=min;loop<=max;loop++){
            candidate[loop-min] = loop;   
        }
        
        for(int n : candidate){
            // Hindex 후보보다 이상으로 인용된 논문
            int[] gteList = Arrays.stream(citations)
                                  .filter(d->n<=d).toArray();
            // Hindex 후보보다 이상으로 인용된 논문의 수가 Hindex 보다 같거나 많고
            // 나머지가 Hindex 이하인것을 answer로 업데이트
            // cadidate가 최소부터 최대로 저장되어 있으므로 가장 마지막에 업데이트 된 값이 최대값이다.
            if(gteList.length>=n && (citations.length - gteList.length)<=n){
                answer = n;
            }
            
        }
        
        return answer;
    }
}