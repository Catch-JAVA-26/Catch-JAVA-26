import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        int answer = 0;
        
        // int 2차원 배열로 선언하면 메모리 초과 에러가 발생하여 boolean으로 변경
        boolean[][] node = new boolean[n][n];
        
        // Node끼리 연결되어 있다면 node 2차원 배열에 true로 표시한다.
        for(int[] e : edge){
            node[e[0]-1][e[1]-1] = true;
            node[e[1]-1][e[0]-1] = true;
        }
        // 가장 먼 노드의 개수를 answer에 저장한다.
        answer = checkDistance(node);
                
        return answer;
    }
    
    public static int checkDistance(boolean[][] node){
        
        // 각 노드와 1번 노드와의 거리를 저장하기 위한 배열
        int[] distance = new int[node.length];      
        
        // 연결된 노드를 순회하기 위해 queue 생성
        Vector<int[]> queue = new Vector<>();
        // 1번이 시작점이기 때문에 0(1이 0번째이므로)과 0(거리)로 구성된 배열을 queue에 추가한다
        queue.add(new int[]{0,0});
        // 노드와의 거리를 비교할때 distance가 0일때 체크할것이기에, 1번 노드는 -1을 저장한다.
        distance[0] = -1;
        
        // queue가 모두 비워질때까지 반복문을 실행
        while(!queue.isEmpty()){
            // 가장 앞에 있는 배열을 꺼내서 해당 노드와 연결된 아직 거리를 측정하지 않은 노드를 다시 queue에 넣는다.
            // distance에는 꺼낸 노드의 거리보다 1을 증가시켜서 저장한다.
            int[] point = queue.get(0);
            queue.remove(0);
            for(int loop=0;loop<node.length;loop++){
                if(node[point[0]][loop] && distance[loop]==0){
                    queue.add(new int[]{loop,point[1]+1});
                    distance[loop] = point[1]+1;
                }
            }
        }
        
        // 가장 먼 노드의 거리를 알기 위해서 오름차순 정렬을 한 후 가장 마지막 값을 max로 저장한다.
        Arrays.sort(distance);
        int max = distance[node.length-1];
        int maxCount = 0;
        // distance를 순회하며, 가장 먼 거리와 동일한 값일 경우 maxCount를 증가시켜 가장 멀리 떨어진 노드의 개수를 센다.
        for(int loop=0;loop<node.length;loop++){
            if(distance[loop]==max){
                maxCount++;
            }
        }
        
        return maxCount;
    }
}