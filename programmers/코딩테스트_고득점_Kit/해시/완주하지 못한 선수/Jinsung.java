import java.util.*;
import java.io.*;
class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        ArrayList<String> pLst = new ArrayList<>(Arrays.asList(participant));
        ArrayList<String> cLst = new ArrayList<>(Arrays.asList(completion));
        HashSet pSet = new HashSet<String>(Arrays.asList(participant));
        HashSet cSet = new HashSet<String>(Arrays.asList(completion));
        Iterator iter = pSet.iterator();
        while(iter.hasNext()){
            System.out.println(Collections.frequency(pLst,iter.next()));    
        }
        // participant로 만든 HashSet에서 completion으로 만든 HashSet을 뺀다
        pSet.removeAll(cSet);
        // pSet 남은 선수가 있다면 해당 값 반환 
        if(pSet.size()!=0){
            String aList[] = new String[pSet.size()];
            pSet.toArray(aList);
            answer = aList[0];
        }
        else{
            // Array를 ArrayList로 변경하여 completion에 있는 이름을 participant에서 뺀다.
            ArrayList<String> pList = new ArrayList<>(Arrays.asList(participant));
            ArrayList<String> cList = new ArrayList<>(Arrays.asList(completion));
            for(String s : cList){
                pList.remove(s);
            }
            answer = pList.get(0);
        }
        return answer;
    }
}