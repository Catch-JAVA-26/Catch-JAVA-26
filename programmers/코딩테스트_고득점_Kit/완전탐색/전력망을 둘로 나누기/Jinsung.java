import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Solution {
    public int solution(int n, int[][] wires) {
        int answer = n;
        // 전력망 하나씩 제거하며, 전력망을 제거했을때 어떻게 나눠지는지 확인 후 가장 적게 차이나는 값을 answer에 저장
        for(int i=0;i<wires.length;i++){
            answer = Math.min(answer,fullScan(n,wires,i));
        }
        
        return answer;
    }
    
    // 모든 전선을 끊어보면서 두 전력망의 차이를 반환
    public int fullScan(int n, int[][] wires,int disconnect){
        
        int[][] link = new int[n+1][n+1];
        int[] visit = new int[n+1];
        
        // wiresList에 전력망 정보를 모두 넣는다.
        ArrayList<int[]> wiresList = new ArrayList<>();
        for(int[] w : wires){
            wiresList.add(w);
        }
        
        // disconnect 위치에 있는 연결선을 제거한다.
        wiresList.remove(disconnect);
        // 나머지 연결망 정보를 link 2중 배열에 넣는다.
        for(int[] w : wiresList){
            link[w[0]][w[1]] = w[1];
            link[w[1]][w[0]] = w[0];
        }
        
        // 모든 point를 확인하며, Network 개수를 파악한다.
        for(int i=1;i<=n;i++){
            visit = checkNetwork(link,visit,i);    
        }
        // 0을 제외한 송전탑이 어떤 전력망을 주축으로 연결되어 있는지 확인하고 그 개수를 센다.
        visit = Arrays.copyOfRange(visit,1,n+1);
        Arrays.sort(visit);
        int min = visit[0];
        int max = visit[visit.length-1];
        min = countPoint(visit,min);
        max = countPoint(visit,max);
        
        return Math.abs(min-max);
    }
    
    // 연결된 전력망이 어디와 연결되어 있는지 check한다.
    public int[] checkNetwork(int[][] grid,int[] visit,int start){
        
        if(visit[start]!=0){
            return visit;
        }else{
            visit[start] = start;
        
            List<Integer> connection = Arrays.stream(grid[start]).filter(d -> d!=0).boxed().collect(Collectors.toList());
            Queue<Integer> que = new LinkedList<>();
            que.addAll(connection);

            while(!que.isEmpty()){
                int point = que.remove();
                if(visit[point]==0){
                    visit[point] = start;
                    connection = Arrays.stream(grid[point]).filter(d -> d!=0).boxed().collect(Collectors.toList());
                    que.addAll(connection);
                }
            }
            return visit;    
        }
    }
    
    // 각 전력망이 연결된 송전탑의 개수를 세어 반환한다.
    public int countPoint(int[] link,int point){
        int cnt = 0;
        for(int loop=0;loop<link.length;loop++){
            if(link[loop]==point){
                cnt++;
            }
        }
        return cnt;
    }
    
}