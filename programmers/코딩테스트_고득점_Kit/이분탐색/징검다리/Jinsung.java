import java.util.*;
class Solution {
    public int solution(int distance, int[] rocks, int n) {
        int answer = 0;
        int size = rocks.length + 2;
        int[] points = new int[size];
        HashSet<Integer> diffDistance = new HashSet<>();
        
        // 모든 돌을 제거하면 출발점부터 도착점까지의 거리이므로, 도착점을 반환한다.
        if(rocks.length == n){
            return distance;
        }
        
        // 바위들을 출발점과의 거리 순으로 정렬한다.
        Arrays.sort(rocks);
        
        for(int loop=0;loop<rocks.length+2;loop++){
            if(loop==0){
                points[loop] = 0;
            }else if(loop==rocks.length+1){
                points[loop] = distance;
            }else{
                points[loop] = rocks[loop-1];
                // n보다 작거나 같을경우 출발점부터 돌까지의 거리가 거리의 최솟값이 될 수 있으므로, diffDistance에 추가한다.
                if(loop<=n)
                    diffDistance.add(points[loop]);
            }
        }
        
        // 출발점,돌 사이의 거리,마지막 돌과 도착점 사이의 거리를 diffDistance에 추가한다.
        for(int d = 0; d < points.length-1;d++){
            diffDistance.add(points[d+1]-points[d]);
        }
        
        // diffDistance는 순서보장이 되지 않으므로, Ingeter 배열로 변경한 후 거리가 짧은 순서대로 정렬한다.
        Integer[] diff = diffDistance.toArray(new Integer[0]);
        Arrays.sort(diff);
                
        return diff[n];
    }
}