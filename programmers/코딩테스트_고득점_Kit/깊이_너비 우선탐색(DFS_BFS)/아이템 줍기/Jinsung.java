import java.util.*;
import java.awt.Point;

class Solution {
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int answer = 0;
        int[][] map = new int[102][102];
        
        // 사각형의 테두리만 길을 만드는 작업
        // 자신의 좌측 하단 x*2, 우측 상단 x*2와 같은 좌표면 1
        // 자신의 좌측 하단 y*2, 우측 상단 y*2와 같은 좌표면 1
        // 너비가 1인 사각형의 경우 테두리와 내부의 점이 같으므로 각 좌표의 x 2를 해야만 테두리와 내부를 구분할 수 있기에
        // 좌표를 2를 곱한다.
        for(int loop=0;loop<rectangle.length;loop++){
            int[] square = rectangle[loop]; 
            for(int r = square[0]*2;r<=square[2]*2;r++){
                for(int c=square[3]*2;c>=square[1]*2;c--){
                    if(c == square[1]*2 || c == square[3]*2){
                        map[r][c] = 1;
                    }
                    else if(r == square[0]*2 || r == square[2]*2){
                        map[r][c] = 1;
                    }
                    else{
                        map[r][c] = 0;
                    }
                }
            }
        }
        
        // 사각형이 겹쳐서 다른 사각형에 포함된 부분을 제거하는 작업(rectangle을 거꾸로 순회하며, 겹쳐졌던 테두리를 모두 지운다.)
        // 자신의 좌측 하단 x*2, 우측 상단 x*2와 같은 좌표면 1
        // 자신의 좌측 하단 y*2, 우측 상단 y*2와 같은 좌표면 1
        // 너비가 1인 사각형의 경우 테두리와 내부의 점이 같으므로 각 좌표의 x 2를 해야만 테두리와 내부를 구분할 수 있기에
        // 좌표를 2를 곱한다.
        for(int loop=rectangle.length-1;loop>=0;loop--){
            int[] square = rectangle[loop]; 
            for(int r = square[0]*2;r<=square[2]*2;r++){
                for(int c=square[3]*2;c>=square[1]*2;c--){
                    if(c != square[1]*2 && c != square[3]*2 && r != square[0]*2 && r != square[2]*2){
                        map[r][c] = 0;
                    }
                }
            }
        }
        // BFS를 통해 캐릭터의 위치에서 아이템 위치까지의 가장 짧은 거리를 구한다.
        answer = findShortCutRoute(map,new int[]{characterX*2,characterY*2},new int[]{itemX*2,itemY*2});
        
        // 좌표값을 2배로 했기 때문에, 거리를 2분의 1한 결과값을 반환한다.
        return answer/2;
    }
    
    // BFS를 통해 가장 짧은 경로를 찾는다.
    public static int findShortCutRoute(int[][] map,int[] start,int[] target){
        int[] dx = {0,1,0,-1};
        int[] dy = {1,0,-1,0};
        int x=0,y=0;
        int[][] check = new int[map.length][map.length];
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(start[0],start[1]));
        check[start[0]][start[1]] = 1;
        
        while(!queue.isEmpty()){
            Point cur = queue.poll();
            x = (int) cur.getX();
            y = (int) cur.getY();
            
            if(x == target[0] && y == target[1]){
                break;
            }
            for(int loop=0;loop<4;loop++){
                int tx = x+dx[loop];
                int ty = y+dy[loop];
                if(tx>=0 && tx<102 && ty>=0 && ty<=102 && check[tx][ty]==0 && map[tx][ty]==1){
                    queue.add(new Point(tx,ty));
                    check[tx][ty] = check[x][y]+1;
                }
            }
        }
        
        return check[x][y]-1;
    }
}