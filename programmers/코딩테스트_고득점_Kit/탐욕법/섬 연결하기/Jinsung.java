import java.util.*;

class Solution {
    public int solution(int n, int[][] costs) {
        // 섬과 섬이 연결된 상태를 저장
        int[][] connect = new int[n][n];
        // 섬의 개수와 연결된 개수 선언
        int answer = 0,connection = 0,island = 0;
        // 건설비용이 낮은 순서대로 경로를 정렬한다.
        Arrays.sort(costs, (c1,c2) -> c1[2] > c2[2] ? 1 : -1 );
        
        // 다리를 순회하면서 하나씩 연결해보고 만일 연결된 개수가 증가증가하지 않으면 연결을 해제한다.
        for(int[] c : costs){
            connect[c[0]][c[1]] = c[0]+1;
            connect[c[1]][c[0]] = c[1]+1;
            connection = countConnection(connect);
            if(island>=connection){
                connect[c[0]][c[1]] = 0;
                connect[c[1]][c[0]] = 0;
            }else{
                island = connection;
                answer += c[2];
            }
        }
        
        return answer;
    }
    
    public int countConnection(int[][] connect){
        
        int count = 0;
        
        Queue<Integer> queue = new LinkedList<>();
        int[] visit = new int[connect.length];
        // 섬과 섬이 연결된 개수를 파악한다.
        for(int loop=0;loop<connect.length;loop++){
            queue.add(loop);
            visit[loop] = 1;
            while(!queue.isEmpty()){
                int island = queue.poll();
                for(int i=0;i<connect.length;i++){
                    if(connect[island][i]!=0 && visit[i]!=1){
                        queue.add(i);
                        visit[i] = 1;
                        count+=1;
                    }
                }    
            }
        }
        return count;
    }
}