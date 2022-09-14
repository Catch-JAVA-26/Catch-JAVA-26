import java.util.*;

class Solution {
    List<String> answerStack;
    boolean[] visit;

    public String[] solution(String[][] tickets) {
        String[] answer = new String[tickets.length+1];
        visit = new boolean[tickets.length];

        Arrays.sort(tickets, (o1, o2) -> {
            if (o2[0].equals(o1[0])) {
                return o2[1].compareTo(o1[1]);
            }
            return o2[0].compareTo(o1[0]);
        });

        List<String> route = new ArrayList<>();
        route.add("ICN");

        dfs(tickets, route);

        int i=0;
        for (String city: answerStack) {
            answer[i++] = city;
        }

        return answer;
    }

    public void dfs(String[][] tickets, List<String> route) {
        if (route.size() == tickets.length + 1) {
            answerStack = route;
            return;
        }

        for (int i=0; i<tickets.length; i++) {
            if (!visit[i] && route.get(route.size()-1).equals(tickets[i][0])) {
                visit[i] = true;

                List<String> newRoute = new ArrayList<>();
                newRoute.addAll(route);
                newRoute.add(tickets[i][1]);

                dfs(tickets, newRoute);

                visit[i] = false;
            }
        }
    }
}