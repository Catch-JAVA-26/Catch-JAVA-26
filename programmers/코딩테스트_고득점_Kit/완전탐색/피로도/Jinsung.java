import java.util.*;

class Solution {
    public int solution(int k, int[][] dungeons) {
        int answer = 0;
        ArrayList<int[]> target = new ArrayList<>();
        ArrayList<Target> box = new ArrayList<>();
        for(int[] d : dungeons){
            target.add(d);
        }
        
        Target cur = new Target();
        int[] empty = new int[2];
        
        for(int loop=0;loop<target.size();loop++){
            ArrayList<int[]> copyTarget =  (ArrayList<int[]>)  target.clone();
            // 던전 중 현재 피로도로 탐험 가능한 던전이 있다면 던전 탐험 후 나머지 던전 목록으로 maxVisit을 탐색
            if(k>=target.get(loop)[0]){
                cur.updateTarget(1,k-target.get(loop)[1]);
            }else{
                cur.updateTarget(0,k);
            }
            copyTarget.remove(loop);
            box.add(maxVisitDungeons(copyTarget,cur));
        }
        
        // 각각의 경우의 수 탐험결과 중 가장 방문 횟수가 많은 수를 answer에 저장
        for(Target t : box){
            answer = t.getVisitCount()>answer?t.getVisitCount():answer;
        }
        
        return answer;
    }

    // 특정 던전을 방문 후 나머지를 방문 가능한지 확인
    public Target maxVisitDungeons(ArrayList<int[]> target,Target cur){
        
        ArrayList<Target> box = new ArrayList<>(); 
        
        // 만일 target 던젼이 없다면 현재 cur을 반환한다.
        if(target.isEmpty()){
            return cur;
        }
        else if(target.size()==1 && target.get(0)[0] <= cur.getEnergy() ){    // 만일 던전이 하나 있고 현재 에너지로 해당 던전을 탐험할 수 있다면 탐험.
            cur.updateTarget(cur.getVisitCount()+1,cur.getEnergy()-target.get(0)[1]);
            return cur;
        }else{
            // 전달받은 던전을 하나씩 체크해보며 해당 던전을 탐험 가능하다면 탐험하고, 나머지 던전을 탐험 가능한지 maxVisitDungeons에 넘김
            for(int loop=0;loop<target.size();loop++){
                ArrayList<int[]> copyTarget =  (ArrayList<int[]>)  target.clone();
                Target next = new Target();
                if(cur.getEnergy()>=target.get(loop)[0]){
                    next.updateTarget(cur.getVisitCount()+1,cur.getEnergy()-target.get(loop)[1]);
                }else{
                    next = cur;
                }
                copyTarget.remove(loop);
                box.add(maxVisitDungeons(copyTarget,next));
            }
            
            // 탐험한 결과를 가지고 방문횟수가 많은, 피로도가 많이 남은 순서로 정렬
            Collections.sort(box,(Target t1, Target t2) -> {
                // 만일 방문한 던전의 개수가 동일할 경우 소모한 피로도가 적은 순서로 정렬 
                if(t1.getVisitCount()==t1.getVisitCount()){
                     return Integer.compare(t1.getEnergy(),t2.getEnergy());
                 }else{ // 만일 방문한 던전의 개수가 동일하지 않을경우, 방문한 던전의 개수가 많은 순서로 정렬  
                    return Integer.compare(t2.getVisitCount(),t1.getVisitCount());
                }
            });
            
            cur = box.get(0);
            
        }
        
        return cur;

    }
    
    public class Target {
        int visitCount = 0;
        int energy = 0;
        
        public void updateTarget(int visitCount,int energy){
            this.visitCount = visitCount;
            this.energy = energy;
        }
        
        public void setVisitCount(int visitCount){
            this.visitCount = visitCount;
        }
        
        public void setEnergy(int energy){
            this.energy = energy;
        }
                
        public int getVisitCount(){
            return visitCount;
        }
        
        public int getEnergy(){
            return energy;
        }
        
    }
}
