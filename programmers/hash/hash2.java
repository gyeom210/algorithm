import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        Map<String, String> map = new HashMap<>();
        
        for(int i = 1; i < phone_book.length; i++){
            map.put(phone_book[i], "prefix");
        }
        for(String key : map.keySet()){
            if(key.contains(phone_book[0]) == true)
                return false;
        }
        return answer;
    }
}
