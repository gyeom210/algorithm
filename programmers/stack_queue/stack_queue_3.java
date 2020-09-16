import java.util.*;
class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        Queue<Integer> q = new LinkedList<>();
        int truck = 0;
        
        for(int t : truck_weights){
            while(true){
                if(q.isEmpty()){
                    q.offer(t);
                    answer++;
                    truck += t;
                    break;
                }else if(q.size() == bridge_length){
                    truck -= q.poll();
                }else{
                    if(truck + t > weight){
                        q.offer(0);
                        answer++;
                    }else{
                        q.offer(t);
                        truck += t;
                        answer++;
                        break;
                    }        
                }
            }
        }
        return answer + bridge_length;
    }
}