import java.util.*;
class Solution {
    public int[] solution(int[] prices) {
        ArrayList<Integer> list = new ArrayList<>();
    
        for(int i = 0; i < prices.length; i++){
            int num = prices[i];
            int cnt = 0;    
            for(int j = i + 1; j < prices.length; j++){
                if(num > prices[j]){
                    cnt++;
                    break;
                }
                cnt++;
            }
            list.add(cnt);
        }
        int[] answer = new int[list.size()];
        
        for(int i = 0; i < list.size(); i++){
            answer[i] = list.get(i);
        }
        return answer;
    }
}

