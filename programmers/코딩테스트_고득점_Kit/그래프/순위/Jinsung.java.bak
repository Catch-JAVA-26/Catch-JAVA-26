import java.util.*;
import java.awt.Point;

class Solution {
    public int solution(int[] arrows) {
        int answer = 0;
        Point cur = new Point(0,0);
        
        int[] mx = new int[] {0,1,1,1,0,-1,-1,-1};
        int[] my = new int[] {1,1,0,-1,-1,-1,0,1};
        
        Map<Point,List<Point>> box = new HashMap<>();
        
        for(int i=0;i<arrows.length;i++){
            // 선을 교차할 경우에도 둘러싼 방이 생성될 수 있으므로 선의 길이를 2배로 하여 교차점도 좌표를 저장한다.
            for(int loop=0;loop<2;loop++){
                int moveX = (int) cur.getX() + mx[arrows[i]];
                int moveY = (int) cur.getY() + my[arrows[i]];
                Point move = new Point(moveX,moveY);     
                // 기존에 지나가지 않은 point라면
                if(!box.containsKey(move)){
                    // 해당 포인트에 대한 정보를 만들고 현재 위치에서 해당 포인트로 왔다는 정보의 list도 만든다.
                    box.put(move,createConnectList(cur));
                    // 만일 지나가는 Point(move)에서 현재 Point로 역으로 지나갈 수 있으므로,
                    // 현재 포인트에 대한 정보를 만들고 지나가는 Point에서 현재 포인트로의 간선도 만들어 준다.
                    if(box.get(cur) == null){
                        box.put(cur,createConnectList(move));
                    }else{
                        box.get(cur).add(move);
                    }    
                }else if(box.containsKey(move) && !box.get(move).contains(cur)){
                    // 만일 지나가려는 Point가 이미 지나간 Point이며, 이전에 지나가지 않은 Point이면 하나의 방이 만들어졌다고 간주한다.
                    box.get(move).add(cur);
                    box.get(cur).add(move);
                    answer++;
                }
                // 이동한 Point를 현재 Point로 업데이트 한다.
                cur = move;
            }
        }
        
        return answer;
    }
    
    // 해당 Point와 연결된 선들이 없었을 경우, 해당 선과의 연결관계를 맞은 Point들의 정보를 저장하는 List 생성 메서등
    public List<Point> createConnectList(Point point){
        List<Point> lst = new ArrayList<>();
        lst.add(point);
        return lst;
    }
    
}