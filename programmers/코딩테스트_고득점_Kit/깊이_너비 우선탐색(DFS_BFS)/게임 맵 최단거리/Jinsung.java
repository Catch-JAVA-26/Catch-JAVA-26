import java.util.*;
import java.awt.Point;
class Solution {
    public int solution(int[][] maps) {
        // 게임 맵의 가장 최단거리를 찾는다.
        int answer = shortcutDistance(maps);
        
        return answer == 0 ? -1 : answer;
    }
    
    public static int shortcutDistance(int[][] maps){
        
        int[] dx = {1,-1,0,0};
        int[] dy = {0,0,1,-1};
        int[][] check = new int[maps.length][maps[0].length];
        Queue<Point> queue = new LinkedList<>();
        // 게임 맵의 시작점을 queue에 넣고, check에도 1을 저장한다.
        queue.add(new Point(0,0));
        check[0][0] = 1;
        // 갈 수 있는 경로를 담은 queue가 모두 비워질때까지 반복문을 계속 실행한다.
        while(!queue.isEmpty()){        
            Point cur = queue.poll();
            int x = (int) cur.getX();
            int y = (int) cur.getY();
            int move = check[x][y];
            // 4방위를 보면서, 해당 위치가 맵을 벗어나지 않고, 방문하지 않았으며, 벽으로 막혀있지 않다면 
            // 갈 수 있는 경로 queue에 담고, check에도 이동한 수를 저장한다.
            for(int i=0;i<4;i++){
                int tx = x + dx[i];
                int ty = y + dy[i];
                if(tx>=0 && tx<maps.length && ty>=0 && ty<maps[0].length && check[tx][ty]==0 && maps[tx][ty]==1){
                    queue.add(new Point(tx,ty));
                    check[tx][ty] = move+1;
                }
            }
        }
        
        // 내가 상대팀 진영에 도착한 최단거리를 반환한다.
        return check[maps.length-1][maps[0].length-1];
    }
    
}