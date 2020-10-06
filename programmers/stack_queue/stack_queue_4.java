import java.util.*;
class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        List<Integer> pri = new ArrayList<Integer>();
        List<Integer> loc = new ArrayList<Integer>();
        
        for(int i = 0; i < priorities.length; i++){
            pri.add(priorities[i]);
            loc.add(i);
        }
        
        int count = 0;
        while(true){
            int p = pri.get(0);
            int l = loc.get(0);
            pri.remove(0);
            loc.remove(0);
            
            if(pri.size() == 0){
                answer += count + 1;
                break;
            }
            
            if(Collections.max(pri) > p){
                pri.add(p);
                loc.add(l);
            }else{
                count += 1;

                if(location == l){
                    answer = count;
                    break;
                }
            }
        }
        
        return answer;
    }
}