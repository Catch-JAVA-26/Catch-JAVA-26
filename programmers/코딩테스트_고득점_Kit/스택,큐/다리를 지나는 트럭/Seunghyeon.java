import java.util.*;

class Seunghyeon {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 1;
        Queue<Truck> bridge = new LinkedList<>();
        int idx = 0;
        int truck = truck_weights[idx++];
        bridge.offer(new Truck(truck, answer));

        int bridge_weight = truck;
        while (!bridge.isEmpty()) {
            answer++;
            if (bridge.peek() != null && answer - bridge.peek().time >= bridge_length) {
                bridge_weight -= bridge.poll().weight;
            }
            if (idx < truck_weights.length && bridge_weight + truck_weights[idx] <= weight && bridge.size() < bridge_length) {
                truck = truck_weights[idx++];
                bridge.offer(new Truck(truck, answer));
                bridge_weight += truck;
            }
        }

        return answer;
    }

    class Truck {
        int weight;
        int time;

        Truck(int weight, int time) {
            this.weight = weight;
            this.time = time;
        }
    }
}